package br.com.cadpessoas.api.controller;

import br.com.cadpessoas.domain.model.PessoaModel;
import br.com.cadpessoas.domain.usecase.SalvarPessoaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SalvarPessoaController {

    private final SalvarPessoaUseCase salvarPessoaUseCase;

    @PostMapping("/salvar")
    public ResponseEntity<PessoaModel> salvarPessoa(@RequestBody PessoaRequest pessoaRequest){
        return ResponseEntity.ok(salvarPessoaUseCase.salvarPessoa(
                new PessoaModel(null, pessoaRequest.nome())
        ));
    }
}
