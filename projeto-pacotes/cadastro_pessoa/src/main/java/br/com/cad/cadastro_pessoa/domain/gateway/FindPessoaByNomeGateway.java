package br.com.cad.cadastro_pessoa.domain.gateway;

import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;

public interface FindPessoaByNomeGateway {

    PessoaModel findPessoaByName(String nome);
}
