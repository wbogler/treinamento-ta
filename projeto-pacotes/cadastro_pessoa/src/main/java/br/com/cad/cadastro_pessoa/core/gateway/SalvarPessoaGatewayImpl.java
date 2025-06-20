package br.com.cad.cadastro_pessoa.core.gateway;

import br.com.cad.cadastro_pessoa.core.entity.PessoaEntity;
import br.com.cad.cadastro_pessoa.core.repository.PessoaRepository;
import br.com.cad.cadastro_pessoa.domain.gateway.SalvarPessoaGateway;
import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarPessoaGatewayImpl implements SalvarPessoaGateway {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public PessoaModel salvar(PessoaModel pessoa) {
        var savedPessoa = pessoaRepository.save(
                PessoaEntity.builder()
                        .nome(pessoa.getNome())
                        .build()
        );

        return new PessoaModel(savedPessoa.getId(), savedPessoa.getNome());
    }
}
