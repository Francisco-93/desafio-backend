package br.com.goldseguradora.modelo.DTO;

import br.com.goldseguradora.modelo.Cliente;
import br.com.goldseguradora.modelo.serializer.DeserializerBigDecimal;
import br.com.goldseguradora.modelo.serializer.DeserializerLocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = DeserializerLocalDate.class)
    private LocalDate inicioVigencia;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = DeserializerLocalDate.class)
    private LocalDate fimVigencia;

    @NotNull
    private String placaVeiculo;

    @NotNull
    @JsonDeserialize(using = DeserializerBigDecimal.class)
    private BigDecimal valorApolice;

    @NotNull
    private Cliente cliente;

    private Boolean apoliceVencida;

    private Integer diasParaVencerOuVencidos;
}
