package br.com.cadpessoas.domain.gateway;


import br.com.cadpessoas.domain.model.PessoaModel;

public interface FindPessoaByNomeGateway {

    PessoaModel findPessoaByName(String nome);
}
