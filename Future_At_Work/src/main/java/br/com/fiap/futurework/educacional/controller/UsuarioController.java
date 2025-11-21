package br.com.fiap.futurework.educacional.controller;

import br.com.fiap.futurework.educacional.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @PostMapping
    public void cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {

        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listarUsuario(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        Usuario usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirUsuario(@PathVariable Long id) {
        Usuario usuario = repository.getReferenceById(id);
        usuario.excluir();
    }
}
