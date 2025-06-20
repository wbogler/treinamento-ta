package br.com.cad.cadastro_pessoa.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
}
