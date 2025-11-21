package br.com.fiap.futurework.educacional.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String titulo;
    private Integer duracao;
    private Integer ano;

    @Enumerated(EnumType.STRING)
    Categoria categoria;

    private String professor;

    public Curso(DadosCadastroCurso dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.categoria = dados.categoria();
        this.professor = dados.professor();
    }

    public void atualizarInformacoes(DadosAtualizacaoCurso dados) {
        if(dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.duracao() != null) {
            this.duracao = dados.duracao();
        }
        if(dados.ano() != null) {
            this.ano = dados.ano();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
