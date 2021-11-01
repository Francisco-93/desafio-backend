package br.com.goldseguradora.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Apolice {

    @Id
    @GeneratedValue(generator = "sq_apolice")
    @SequenceGenerator(name = "sq_apolice", sequenceName = "sq_apolice", initialValue = 10000)
    private Long numeroDaApolice;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String placaVeiculo;
    private BigDecimal valorApolice;

    @ManyToOne
    private Cliente cliente;
}
