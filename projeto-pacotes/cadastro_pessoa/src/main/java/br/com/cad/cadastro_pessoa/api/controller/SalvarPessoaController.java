package br.com.cad.cadastro_pessoa.api.controller;

import br.com.cad.cadastro_pessoa.domain.model.PessoaModel;
import br.com.cad.cadastro_pessoa.domain.usecase.SalvarPessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SalvarPessoaController {

    @Autowired
    private SalvarPessoaUseCase salvarPessoaUseCase;

    @PostMapping("/salvar")
    public ResponseEntity<PessoaModel> salvarPessoa(@RequestBody PessoaRequest pessoaRequest){
        return ResponseEntity.ok(salvarPessoaUseCase.salvarPessoa(
                new PessoaModel(null, pessoaRequest.nome())
        ));
    }
}
