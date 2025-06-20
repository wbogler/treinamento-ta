package br.com.cad.cadastro_pessoa.domain.gateway;

import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;

public interface SalvarPessoaGateway {

    PessoaModel salvar(PessoaModel pessoa);
}
