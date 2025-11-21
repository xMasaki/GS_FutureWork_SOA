package br.com.fiap.futurework.educacional.curso;

public record DadosListagemCurso(
        Long id,
        String titulo,
        Integer ano,
        Categoria categoria) {

    public DadosListagemCurso(Curso curso) {
        this(curso.getId(), curso.getTitulo(), curso.getAno(), curso.getCategoria());
    }
}
