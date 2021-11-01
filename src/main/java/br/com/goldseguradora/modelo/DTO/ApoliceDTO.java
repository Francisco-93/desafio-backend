package br.com.goldseguradora.modelo.DTO;

import br.com.goldseguradora.modelo.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApoliceDTO {

    private Long numeroDaApolice;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicioVigencia;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fimVigencia;

    @NotNull
    private String placaVeiculo;

    @NotNull
    private BigDecimal valorApolice;

    @NotNull
    private Cliente cliente;

    private Boolean apoliceVencida;

    private Integer diasParaVencerOuVencidos;
}
