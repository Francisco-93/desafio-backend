package br.com.goldseguradora.repositorio;

import br.com.goldseguradora.modelo.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApoliceRepositorio extends JpaRepository<Apolice, Long> {

    public List<Apolice> findApoliceByCliente_Id(Long idCliente);

    public List<Apolice> findApoliceByCliente_Cpf(String cpfCliente);
}
