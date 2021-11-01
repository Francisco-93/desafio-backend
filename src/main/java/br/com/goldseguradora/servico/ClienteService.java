package br.com.goldseguradora.servico;

import br.com.goldseguradora.modelo.Cliente;
import br.com.goldseguradora.modelo.DTO.ClienteDTO;
import br.com.goldseguradora.repositorio.ClienteRepositorio;
import br.com.goldseguradora.web.excecao.ExcecaoPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<ClienteDTO> getAllClientes() {
        return this.clienteRepositorio.findAll().stream()
                .map(entidade -> this.entidadeParaDto(entidade)).collect(Collectors.toList());
    }

    public ClienteDTO getClientePorId(Long id) {
        try {
            return this.entidadeParaDto(this.clienteRepositorio.findById(id).get());
        } catch (Exception e) {
            throw new ExcecaoPersonalizada("Cliente não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    public ClienteDTO getClientePorCpf(String cpf) {
        try {
            return this.entidadeParaDto(this.clienteRepositorio.getClienteByCpf(cpf).get());
        }
        catch (Exception e) {
            throw new ExcecaoPersonalizada("Cliente não encontrado na base.", HttpStatus.NOT_FOUND);
        }
    }

    public Cliente inserirCliente(ClienteDTO obj) {
        try{
            return this.clienteRepositorio.save(this.dtoParaEntidade(obj));
        } catch (RuntimeException e){
            throw new ExcecaoPersonalizada("Já existe um cadastro para esse CPF.", HttpStatus.BAD_REQUEST);
        }
    }

    public void atualizarCliente(ClienteDTO obj) {
        Cliente cliente = this.clienteRepositorio.findById(obj.getId()).get();
        cliente.setCpf(obj.getCpf());
        cliente.setNome(obj.getNome());
        cliente.setEndereco(obj.getEndereco());
        this.clienteRepositorio.save(cliente);
    }

    public void deletarCliente(Long id) {
        try {
            this.clienteRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new ExcecaoPersonalizada("Não é possível excluir pois existe uma apólice vinculada à este cliente.", HttpStatus.BAD_REQUEST);
        }
    }

    public Page<ClienteDTO> paginacaoClientes(Integer pagina, Integer linhasPorPágina){
        PageRequest paginacaoRequest = PageRequest.of(pagina, linhasPorPágina);
        Page<Cliente> clientes = this.clienteRepositorio.findAll(paginacaoRequest);
        return clientes.map(entidade -> this.entidadeParaDto(entidade));
    }

    private ClienteDTO entidadeParaDto(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setCpf(cliente.getCpf());
        dto.setNome(cliente.getNome());
        dto.setEndereco(cliente.getEndereco());
        return dto;
    }

    private Cliente dtoParaEntidade(ClienteDTO dto) {
        dto = formatarCPF(dto);
        Cliente entidade = new Cliente();
        entidade.setId(dto.getId());
        entidade.setCpf(dto.getCpf());
        entidade.setNome(dto.getNome());
        entidade.setEndereco(dto.getEndereco());
        entidade.getEndereco().setCliente(entidade);
        return entidade;
    }

    private ClienteDTO formatarCPF(ClienteDTO obj) {
        String cpf = obj.getCpf();
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        obj.setCpf(cpf);
        return obj;
    }
}
