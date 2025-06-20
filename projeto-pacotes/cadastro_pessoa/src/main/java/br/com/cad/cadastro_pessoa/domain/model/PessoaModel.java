package br.com.cad.cadastro_pessoa.domain.model;

public class PessoaModel {

    private Long id;
    private String nome;

    public PessoaModel(){

    }

    public PessoaModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
