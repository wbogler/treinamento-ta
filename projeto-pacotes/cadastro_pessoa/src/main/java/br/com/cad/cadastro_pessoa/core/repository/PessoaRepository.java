package br.com.cad.cadastro_pessoa.core.repository;

import br.com.cad.cadastro_pessoa.core.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    PessoaEntity findPessoaByNome(String nome);
}
