package br.com.cad.cadastro_pessoa.api.config;

import br.com.cad.cadastro_pessoa.domain.gateway.FindPessoaByNomeGateway;
import br.com.cad.cadastro_pessoa.domain.gateway.SalvarPessoaGateway;
import br.com.cad.cadastro_pessoa.domain.usecase.SalvarPessoaUseCase;
import br.com.cad.cadastro_pessoa.domain.usecase.impl.SalvarPessoaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    SalvarPessoaUseCase salvarPessoaUseCase (SalvarPessoaGateway salvarPessoaGateway, FindPessoaByNomeGateway findPessoaByNomeGateway){
        return new SalvarPessoaImpl(salvarPessoaGateway,findPessoaByNomeGateway);
    }
}
