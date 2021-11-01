package br.com.goldseguradora.web;

import br.com.goldseguradora.modelo.Apolice;
import br.com.goldseguradora.modelo.DTO.ApoliceDTO;
import br.com.goldseguradora.servico.ApoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/apolices")
public class ApoliceController {

    @Autowired
    private ApoliceService apoliceService;

    @GetMapping
    public ResponseEntity<List<ApoliceDTO>> getAllApolices(){
        return ResponseEntity.ok(this.apoliceService.getAllApolices());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApoliceDTO> findApolicePorId(@PathVariable Long id){
        return ResponseEntity.ok(this.apoliceService.getApolicePorId(id));
    }

    @GetMapping(value = "/cliente/{idCliente}")
    public ResponseEntity<List<ApoliceDTO>> findApolicePorCliente(@PathVariable Long idCliente){
        return ResponseEntity.ok(this.apoliceService.getApolicePorCliente(idCliente));
    }

    @GetMapping(value = "/cliente/cpf/{cpfCliente}")
    public ResponseEntity<List<ApoliceDTO>> findApolicePorCpfCliente(@PathVariable String cpfCliente){
        return ResponseEntity.ok(this.apoliceService.getApolicePorCpfCliente(cpfCliente));
    }

    @PostMapping
    public ResponseEntity<Void> inserirApolice(@RequestBody ApoliceDTO obj){
        Apolice apolice = this.apoliceService.inserirApolice(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(apolice.getNumeroDaApolice()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarApolice(@RequestBody ApoliceDTO obj){
        this.apoliceService.atualizarApolice(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarApolice(@PathVariable Long id){
        apoliceService.deletaApolice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ApoliceDTO>> paginacaoClientes(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "linhasPorPagina", defaultValue = "10") Integer linhasPorPagina){

        Page<ApoliceDTO> paginacao = this.apoliceService.paginacaoApolice(pagina, linhasPorPagina);
        return ResponseEntity.ok(paginacao);
    }

}
