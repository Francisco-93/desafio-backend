package br.com.goldseguradora.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(generator = "sq_cliente")
    @SequenceGenerator(name = "sq_cliente", sequenceName = "sq_cliente", initialValue = 1)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    @PrimaryKeyJoinColumn
    private Endereco endereco;

}
