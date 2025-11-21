package br.com.fiap.futurework.educacional.controller;

import br.com.fiap.futurework.educacional.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Transactional
    @PostMapping
    public void cadastrarCurso(@RequestBody @Valid DadosCadastroCurso dados) {

        repository.save(new Curso(dados));
    }

    @GetMapping
    public Page<DadosListagemCurso> listarCurso(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCurso::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCurso(@RequestBody @Valid DadosAtualizacaoCurso dados) {
        Curso curso = repository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCurso(@PathVariable Long id) {
        Curso curso = repository.getReferenceById(id);
        curso.excluir();
    }

}
