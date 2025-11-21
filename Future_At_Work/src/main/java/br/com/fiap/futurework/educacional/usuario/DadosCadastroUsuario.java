package br.com.fiap.futurework.educacional.usuario;

import br.com.fiap.futurework.educacional.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String rg,

        @NotNull
        Tipo tipo,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
