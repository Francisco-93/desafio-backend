package br.com.goldseguradora.repositorio;

import br.com.goldseguradora.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
}
