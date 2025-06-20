package br.com.cadpessoas.domain.usecase.impl;

import br.com.cadpessoas.domain.enums.BeanType;
import br.com.cadpessoas.domain.enums.UseCase;
import br.com.cadpessoas.domain.exception.PersonJustRegistredException;
import br.com.cadpessoas.domain.gateway.FindPessoaByNomeGateway;
import br.com.cadpessoas.domain.gateway.SalvarPessoaGateway;
import br.com.cadpessoas.domain.model.PessoaModel;
import br.com.cadpessoas.domain.usecase.SalvarPessoaUseCase;
import lombok.RequiredArgsConstructor;

@UseCase(beanType = BeanType.API)
@RequiredArgsConstructor
public class SalvarPessoaImpl implements SalvarPessoaUseCase {

    private final SalvarPessoaGateway salvarPessoaGateway;

    private final FindPessoaByNomeGateway findPessoaByNome;

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
