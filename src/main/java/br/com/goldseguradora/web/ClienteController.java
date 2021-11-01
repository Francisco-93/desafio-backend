package br.com.goldseguradora.web;

import br.com.goldseguradora.modelo.Cliente;
import br.com.goldseguradora.modelo.DTO.ClienteDTO;
import br.com.goldseguradora.servico.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes(){
        return ResponseEntity.ok(this.clienteService.getAllClientes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findApolicePorId(@PathVariable Long id){
        return ResponseEntity.ok(this.clienteService.getClientePorId(id));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> findClientePorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(this.clienteService.getClientePorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid ClienteDTO obj){
        Cliente cliente = this.clienteService.inserirCliente(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCliente(@RequestBody ClienteDTO obj){
        this.clienteService.atualizarCliente(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDTO>> paginacaoClientes(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "linhasPorPagina", defaultValue = "10") Integer linhasPorPagina){

        Page<ClienteDTO> paginacao = this.clienteService.paginacaoClientes(pagina, linhasPorPagina);
        return ResponseEntity.ok(paginacao);
    }
}
