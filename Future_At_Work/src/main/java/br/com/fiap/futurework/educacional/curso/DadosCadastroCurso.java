package br.com.fiap.futurework.educacional.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(
        @NotBlank
        String titulo,

        @NotBlank
        Integer duracao,

        @NotBlank
        Integer ano,

        @NotNull
        Categoria categoria,

        @NotBlank
        String professor
) {
}
