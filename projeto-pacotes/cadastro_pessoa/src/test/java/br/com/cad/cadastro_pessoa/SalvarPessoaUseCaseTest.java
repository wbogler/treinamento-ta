package br.com.cad.cadastro_pessoa;

import br.com.cad.cadastro_pessoa.domain.gateway.FindPessoaByNomeGateway;
import br.com.cad.cadastro_pessoa.domain.gateway.SalvarPessoaGateway;
import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;
import br.com.cad.cadastro_pessoa.domain.usecase.SalvarPessoaUseCase;
import br.com.cad.cadastro_pessoa.domain.usecase.impl.SalvarPessoaImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Testes do UseCase de salvar pessoa")
@SpringBootTest
public class SalvarPessoaUseCaseTest {

    private SalvarPessoaGateway salvarPessoa;
    private FindPessoaByNomeGateway buscarPessoa;

    private SalvarPessoaUseCase salvarPessoaUseCase;

    @BeforeEach
    void setUp() {
        salvarPessoa = Mockito.mock(SalvarPessoaGateway.class);
        buscarPessoa = Mockito.mock(FindPessoaByNomeGateway.class);

        salvarPessoaUseCase = new SalvarPessoaImpl(salvarPessoa,buscarPessoa);
    }

    @DisplayName("Salvando uma pessoa e retornando o nome com final clean arch")
    @Test
    void salvarPessoaTest(){
        var pessoaToSave = new PessoaModel(null, "willian");
        var pessoa = new PessoaModel(1L, "willian");

        Mockito.when(buscarPessoa.findPessoaByName("willian")).thenReturn(null);
        Mockito.when(salvarPessoa.salvar(pessoaToSave)).thenReturn(pessoa);

        var testSalvamento = salvarPessoaUseCase.salvarPessoa(pessoaToSave);

        Assertions.assertEquals(testSalvamento.getId(),1L);
        Assertions.assertTrue(testSalvamento.getNome().equalsIgnoreCase("willian clean arch"));
    }
}
