package br.com.fiap.futurework.educacional.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCurso(
        @NotNull
        Long id,
        String titulo,
        Integer duracao,
        Integer ano
) {
}
