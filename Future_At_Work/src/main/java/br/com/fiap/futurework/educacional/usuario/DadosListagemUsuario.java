package br.com.fiap.futurework.educacional.usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        String rg,
        Tipo tipo) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRg(), usuario.getTipo());
    }
}
