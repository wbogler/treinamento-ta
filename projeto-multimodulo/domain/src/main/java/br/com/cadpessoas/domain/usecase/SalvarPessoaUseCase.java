package br.com.cadpessoas.domain.usecase;


import br.com.cadpessoas.domain.model.PessoaModel;

public interface SalvarPessoaUseCase {

    PessoaModel salvarPessoa(PessoaModel pessoa);
}
