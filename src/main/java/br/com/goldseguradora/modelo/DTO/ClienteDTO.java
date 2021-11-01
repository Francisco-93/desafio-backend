package br.com.goldseguradora.modelo.DTO;

import br.com.goldseguradora.modelo.Endereco;
import br.com.goldseguradora.modelo.serializer.SerializadorCPF;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotNull
    private String nome;

    @CPF
    @JsonSerialize(using = SerializadorCPF.class)
    private String cpf;

    private Endereco endereco;
}
