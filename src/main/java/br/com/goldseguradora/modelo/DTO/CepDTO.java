package br.com.goldseguradora.modelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CepDTO {

    private String cep;
    private String uf;
    private String logradouro;
    private String localidade;
    private String bairro;

}
