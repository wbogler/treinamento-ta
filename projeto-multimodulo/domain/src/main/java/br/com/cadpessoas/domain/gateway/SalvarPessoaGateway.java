package br.com.cadpessoas.domain.gateway;


import br.com.cadpessoas.domain.model.PessoaModel;

public interface SalvarPessoaGateway {

    PessoaModel salvar(PessoaModel pessoa);
}
