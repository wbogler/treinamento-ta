package br.com.cadpessoas.core.gateway;

import br.com.cadpessoas.core.repository.PessoaRepository;
import br.com.cadpessoas.domain.gateway.FindPessoaByNomeGateway;
import br.com.cadpessoas.domain.model.PessoaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPessoaByNomeGatewayImpl implements FindPessoaByNomeGateway {

    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaModel findPessoaByName(String nome) {
        var pessoa = pessoaRepository.findPessoaByNome(nome);
        if (pessoa != null) {
            return new PessoaModel(pessoa.getId(), pessoa.getNome());
        }
        return null;
    }
}
