package br.com.cadpessoas.core.gateway;

import br.com.cadpessoas.core.entity.PessoaEntity;
import br.com.cadpessoas.core.repository.PessoaRepository;
import br.com.cadpessoas.domain.gateway.SalvarPessoaGateway;
import br.com.cadpessoas.domain.model.PessoaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarPessoaGatewayImpl implements SalvarPessoaGateway {

    private final PessoaRepository pessoaRepository;

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
