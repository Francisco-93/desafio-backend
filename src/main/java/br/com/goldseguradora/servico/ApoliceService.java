package br.com.goldseguradora.servico;

import br.com.goldseguradora.modelo.Apolice;
import br.com.goldseguradora.modelo.DTO.ApoliceDTO;
import br.com.goldseguradora.repositorio.ApoliceRepositorio;
import br.com.goldseguradora.web.excecao.ExcecaoPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApoliceService {

    @Autowired
    private ApoliceRepositorio apoliceRepositorio;

    public List<ApoliceDTO> getAllApolices(){
        return this.apoliceRepositorio.findAll().stream()
                .map(entidade -> this.entidadeParaDto(entidade)).collect(Collectors.toList());
    }

    public ApoliceDTO getApolicePorId(Long id){
        try {
            return this.entidadeParaDto(this.apoliceRepositorio.findById(id).get());
        } catch (Exception e) {
            throw new ExcecaoPersonalizada("Apólice não encontrada.", HttpStatus.NOT_FOUND);
        }
    }

    public List<ApoliceDTO> getApolicePorCliente(Long idCliente){
        try {
            return this.apoliceRepositorio.findApoliceByCliente_Id(idCliente).stream()
                    .map(entidade -> this.entidadeParaDto(entidade)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ExcecaoPersonalizada("Cliente não possui apólices.", HttpStatus.NOT_FOUND);
        }
    }

    public List<ApoliceDTO> getApolicePorCpfCliente(String cpfCliente){
        try {
            return this.apoliceRepositorio.findApoliceByCliente_Cpf(cpfCliente).stream()
                    .map(entidade -> this.entidadeParaDto(entidade)).collect(Collectors.toList());
        }  catch (Exception e) {
            throw new ExcecaoPersonalizada("Cliente não possui apólices.", HttpStatus.NOT_FOUND);
        }
    }

    public Apolice inserirApolice(ApoliceDTO obj){
        return this.apoliceRepositorio.save(this.dtoParaEntidade(obj));
    }

    public void atualizarApolice(ApoliceDTO obj){
        Apolice apolice = this.apoliceRepositorio.findById(obj.getNumeroDaApolice()).get();
        apolice.setInicioVigencia(obj.getInicioVigencia());
        apolice.setFimVigencia(obj.getFimVigencia());
        apolice.setValorApolice(obj.getValorApolice());
        apolice.setPlacaVeiculo(obj.getPlacaVeiculo());
        apolice.setCliente(obj.getCliente());
        this.apoliceRepositorio.save(apolice);
    }

    public void deletaApolice(Long id){
        this.apoliceRepositorio.deleteById(id);
    }

    public Page<ApoliceDTO> paginacaoApolice(Integer pagina, Integer linhasPorPágina){
        PageRequest paginacaoRequest = PageRequest.of(pagina, linhasPorPágina);
        Page<Apolice> clientes = this.apoliceRepositorio.findAll(paginacaoRequest);
        return clientes.map(entidade -> this.entidadeParaDto(entidade));
    }

    private Apolice dtoParaEntidade(ApoliceDTO dto){
        Apolice entidade = new Apolice();
        entidade.setNumeroDaApolice(dto.getNumeroDaApolice());
        entidade.setValorApolice(dto.getValorApolice());
        entidade.setPlacaVeiculo(dto.getPlacaVeiculo());
        entidade.setInicioVigencia(dto.getInicioVigencia());
        entidade.setFimVigencia(dto.getFimVigencia());
        entidade.setCliente(dto.getCliente());
        return entidade;
    }

    private ApoliceDTO entidadeParaDto(Apolice entidade){
        ApoliceDTO dto = new ApoliceDTO();
        dto.setNumeroDaApolice(entidade.getNumeroDaApolice());
        dto.setValorApolice(entidade.getValorApolice());
        dto.setPlacaVeiculo(entidade.getPlacaVeiculo());
        dto.setInicioVigencia(entidade.getInicioVigencia());
        dto.setFimVigencia(entidade.getFimVigencia());
        dto.setCliente(entidade.getCliente());
        dto.setApoliceVencida(this.isApoliceVencida(entidade));
        dto.setDiasParaVencerOuVencidos(Math.abs(this.diasParaVencerOuVencidos(entidade)));
        return dto;
    }

    private Boolean isApoliceVencida(Apolice apolice){
        LocalDate hoje = LocalDate.now();
        return hoje.isAfter(apolice.getFimVigencia()) ? true : false;
    }

    private Integer diasParaVencerOuVencidos(Apolice apolice){
        LocalDate hoje = LocalDate.now();
        int dias = (int) ChronoUnit.DAYS.between(hoje, apolice.getFimVigencia());
        return dias;
    }
}
