package br.com.cad.cadastro_pessoa.domain.usecase.impl;

import br.com.cad.cadastro_pessoa.domain.exception.PersonJustRegistredException;
import br.com.cad.cadastro_pessoa.domain.gateway.FindPessoaByNomeGateway;
import br.com.cad.cadastro_pessoa.domain.gateway.SalvarPessoaGateway;
import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;
import br.com.cad.cadastro_pessoa.domain.usecase.SalvarPessoaUseCase;


public class SalvarPessoaImpl implements SalvarPessoaUseCase {

    private final SalvarPessoaGateway salvarPessoaGateway;

    private final FindPessoaByNomeGateway findPessoaByNome;

    public SalvarPessoaImpl(SalvarPessoaGateway salvarPessoaGateway, FindPessoaByNomeGateway findPessoaByNome) {
        this.salvarPessoaGateway = salvarPessoaGateway;
        this.findPessoaByNome = findPessoaByNome;
    }

    @Override
    public PessoaModel salvarPessoa(PessoaModel pessoa) {
        if(findPessoaByNome.findPessoaByName(pessoa.getNome())==null){
            var regra =  salvarPessoaGateway.salvar(pessoa);
            regra.setNome(regra.getNome()+" clean arch");
            return regra;
        }
        throw new PersonJustRegistredException();
    }
}
