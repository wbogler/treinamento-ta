package br.com.cad.cadastro_pessoa.core.gateway;

import br.com.cad.cadastro_pessoa.core.repository.PessoaRepository;
import br.com.cad.cadastro_pessoa.domain.gateway.FindPessoaByNomeGateway;
import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPessoaByNomeGatewayImpl implements FindPessoaByNomeGateway {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public PessoaModel findPessoaByName(String nome) {
        var pessoa = pessoaRepository.findPessoaByNome(nome);
        if (pessoa != null) {
            return new PessoaModel(pessoa.getId(), pessoa.getNome());
        }
        return null;
    }
}
