package br.com.goldseguradora.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @Column(name = "cliente_id")
    private Long id;
    private String cep;
    private String uf;
    private String logradouro;
    private String cidade;
    private String bairro;
    private Integer numero;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
