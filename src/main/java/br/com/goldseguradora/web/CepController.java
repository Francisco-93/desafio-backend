package br.com.goldseguradora.web;

import br.com.goldseguradora.modelo.DTO.CepDTO;
import br.com.goldseguradora.servico.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepDTO> buscaCep(@PathVariable String cep){
        return ResponseEntity.ok(this.cepService.buscarCep(cep));
    }

}
