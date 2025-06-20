package br.com.cad.cadastro_pessoa.domain.usecase;

import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;

public interface SalvarPessoaUseCase {

    PessoaModel salvarPessoa(PessoaModel pessoa);
}
