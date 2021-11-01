package br.com.goldseguradora.config;

import br.com.goldseguradora.modelo.Apolice;
import br.com.goldseguradora.modelo.Cliente;
import br.com.goldseguradora.modelo.Endereco;
import br.com.goldseguradora.repositorio.ApoliceRepositorio;
import br.com.goldseguradora.repositorio.ClienteRepositorio;
import br.com.goldseguradora.repositorio.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
@Profile("test")
public class CargaInicialConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    private ApoliceRepositorio apoliceRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Endereco e1 = new Endereco(null, "69075431", "AM", "Rua Santo Antônio", "Manaus", "Mauazinho", 22, null);
        Endereco e2 = new Endereco(null, "94859270", "RS", "Rua Herbet José de Souza", "Alvorada", "Jardim Algarve", 32, null);
        Endereco e3 = new Endereco(null, "71256245", "DF", "Quadra 5 Conjunto 19", "Brasília", "Setor Oeste (Vila Estrutural - Guará)", 2, null);
        Endereco e4 = new Endereco(null, "63132700", "CE", "Rua Rui Barbosa", "Crato", "Muriti", 12, null);
        Endereco e5 = new Endereco(null, "69301205", "RR", "Travessa A", "Boa Vista", "Centro", 14, null);
        Endereco e6 = new Endereco(null, "29908170", "ES", "Rua Atahualpa Duarte Calmon Costa", "Linhares", "Santa Cruz", 8, null);
        Endereco e7 = new Endereco(null, "69047501", "AM", "Rua Sarracenia", "Manaus", "Redenção", 9, null);
        Endereco e8 = new Endereco(null, "69921749", "AC", "Rua Rio de Janeiro", "Rio Branco", "Tancredo Neves", 10, null);
        Endereco e9 = new Endereco(null, "57302784", "AL", "Rua Santa Paulina", "Arapiraca", "Canafístula", 34, null);
        Endereco e10 = new Endereco(null, "79814182", "MS", "Rua Pancho Torraca", "Dourados", "COHAB II", 19, null);
        Endereco e11 = new Endereco(null, "69075431", "AM", "Rua Santo Antônio", "Manaus", "Mauazinho", 45, null);
        Endereco e12 = new Endereco(null, "94859270", "RS", "Rua Herbet José de Souza", "Alvorada", "Jardim Algarve", 21, null);
        Endereco e13 = new Endereco(null, "71256245", "DF", "Quadra 5 Conjunto 19", "Brasília", "Setor Oeste (Vila Estrutural - Guará)", 12, null);
        Endereco e14 = new Endereco(null, "63132700", "CE", "Rua Rui Barbosa", "Crato", "Muriti", 19, null);
        Endereco e15 = new Endereco(null, "69301205", "RR", "Travessa A", "Boa Vista", "Centro", 32, null);
        Endereco e16 = new Endereco(null, "69301205", "RR", "Travessaiada ABC", "Belas Artes", "Centro Econômico", 32, null);

        Cliente c1 = new Cliente(null, "Francisco Frota de Aguiar", "81297334043", e1);
        Cliente c2 = new Cliente(null, "Miriã Costa Barros", "72297124082", e2);
        Cliente c3 = new Cliente(null, "Marcelo Souza Farias", "99270847063", e3);
        Cliente c4 = new Cliente(null, "Lucas Figueira Gonçalves", "00517113031", e4);
        Cliente c5 = new Cliente(null, "Priscila Costa Figueira", "19369704060", e5);
        Cliente c6 = new Cliente(null, "Samara Lima Monté", "42069895084", e6);
        Cliente c7 = new Cliente(null, "Manoel Ferreira Machado", "99449225010", e7);
        Cliente c8 = new Cliente(null, "Maria Batista Lima", "40798579005", e8);
        Cliente c9 = new Cliente(null, "Paulo José Pires Noronha", "13904874071", e9);
        Cliente c10 = new Cliente(null, "Jonas Gadelha da Silva", "62572152002", e10);
        Cliente c11 = new Cliente(null, "Geovane Vieira Paretto", "81985470020", e11);
        Cliente c12 = new Cliente(null, "Rafael da Silva Mourão", "98714128004", e12);
        Cliente c13 = new Cliente(null, "Lilian Soares Ferreira", "52416773054", e13);
        Cliente c14 = new Cliente(null, "Eduarda Costa Ferraz", "20804058024", e14);
        Cliente c15 = new Cliente(null, "Lindomar Pereira Duarte", "99792335080", e15);
        Cliente c16 = new Cliente(null, "Franciquito Frota de Aguiar", "32784205002", e16);

        e1.setCliente(c1); e2.setCliente(c2); e3.setCliente(c3);
        e4.setCliente(c4); e5.setCliente(c5); e6.setCliente(c6);
        e7.setCliente(c7); e8.setCliente(c8); e9.setCliente(c9);
        e10.setCliente(c10); e11.setCliente(c11); e12.setCliente(c12);
        e13.setCliente(c13); e14.setCliente(c14); e15.setCliente(c15); e16.setCliente(c16);

        Apolice a1 = new Apolice(null, LocalDate.of(2018, Month.AUGUST, 12), LocalDate.of(2023, Month.AUGUST, 11), "PBP-3758", new BigDecimal(45000.0), c1);
        Apolice a2 = new Apolice(null, LocalDate.of(2014, Month.SEPTEMBER, 13), LocalDate.of(2019, Month.SEPTEMBER, 12), "MWQ-7342", new BigDecimal(78550.0), c1);
        Apolice a3 = new Apolice(null, LocalDate.of(2010, Month.OCTOBER, 14), LocalDate.of(2015, Month.OCTOBER, 13), "HUO-9262", new BigDecimal(34780.0), c2);
        Apolice a4 = new Apolice(null, LocalDate.of(2019, Month.NOVEMBER, 15), LocalDate.of(2024, Month.NOVEMBER, 14), "KAK-9655", new BigDecimal(44590.0), c2);
        Apolice a5 = new Apolice(null, LocalDate.of(2020, Month.DECEMBER, 16), LocalDate.of(2025, Month.DECEMBER, 15), "HJT-4634", new BigDecimal(88500.0), c2);
        Apolice a6 = new Apolice(null, LocalDate.of(2021, Month.JANUARY, 17), LocalDate.of(2026, Month.JANUARY, 16), "BDA-9394", new BigDecimal(110578.90), c3);
        Apolice a7 = new Apolice(null, LocalDate.of(2013, Month.FEBRUARY, 18), LocalDate.of(2018, Month.FEBRUARY, 17), "MZU-0115", new BigDecimal(34765.98), c4);
        Apolice a8 = new Apolice(null, LocalDate.of(2012, Month.MARCH, 19), LocalDate.of(2017, Month.MARCH, 18), "ADO-0425", new BigDecimal(22356.89), c5);
        Apolice a9 = new Apolice(null, LocalDate.of(2015, Month.APRIL, 20), LocalDate.of(2020, Month.APRIL, 19), "NEJ-6963", new BigDecimal(86533.98), c5);
        Apolice a10 = new Apolice(null, LocalDate.of(2019, Month.MAY, 21), LocalDate.of(2024, Month.MAY, 20), "MTF-3433", new BigDecimal(12387.09), c6);
        Apolice a11 = new Apolice(null, LocalDate.of(2018, Month.JUNE, 22), LocalDate.of(2023, Month.JUNE, 21), "AKB-1048", new BigDecimal(64342.34), c7);
        Apolice a12 = new Apolice(null, LocalDate.of(2020, Month.JULY, 23), LocalDate.of(2025, Month.JULY, 22), "LWD-0330", new BigDecimal(25657.84), c8);
        Apolice a13 = new Apolice(null, LocalDate.of(2021, Month.AUGUST, 7), LocalDate.of(2026, Month.AUGUST, 6), "JFK-9989", new BigDecimal(56423.97), c9);
        Apolice a14 = new Apolice(null, LocalDate.of(2018, Month.SEPTEMBER, 8), LocalDate.of(2023, Month.SEPTEMBER, 7), "MUE-4204", new BigDecimal(23567.56), c9);
        Apolice a15 = new Apolice(null, LocalDate.of(2017, Month.OCTOBER, 3), LocalDate.of(2022, Month.OCTOBER, 2), "NEL-2944", new BigDecimal(65743.90), c10);
        Apolice a16 = new Apolice(null, LocalDate.of(2016, Month.NOVEMBER, 5), LocalDate.of(2021, Month.NOVEMBER, 4), "MTV-1539", new BigDecimal(45787.56), c11);
        Apolice a17 = new Apolice(null, LocalDate.of(2018, Month.DECEMBER, 10), LocalDate.of(2023, Month.DECEMBER, 9), "MQG-9495", new BigDecimal(67585.90), c12);
        Apolice a18 = new Apolice(null, LocalDate.of(2014, Month.JANUARY, 12), LocalDate.of(2019, Month.JANUARY, 11), "MZT-7264", new BigDecimal(86443.87), c13);
        Apolice a19 = new Apolice(null, LocalDate.of(2013, Month.FEBRUARY, 21), LocalDate.of(2018, Month.FEBRUARY, 20), "NEC-2774", new BigDecimal(98346.64), c14);
        Apolice a20 = new Apolice(null, LocalDate.of(2011, Month.MARCH, 19), LocalDate.of(2016, Month.MARCH, 18), "IFY-2390", new BigDecimal(45756.40), c15);

        this.enderecoRepositorio.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10, e11, e12, e13, e14, e15, e16));
        this.clienteRepositorio.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15, c16));
        this.apoliceRepositorio.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20));
    }
}
