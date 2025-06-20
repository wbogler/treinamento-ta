package br.com.cadpessoas.core.repository;

import br.com.cadpessoas.core.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    PessoaEntity findPessoaByNome(String nome);
}
