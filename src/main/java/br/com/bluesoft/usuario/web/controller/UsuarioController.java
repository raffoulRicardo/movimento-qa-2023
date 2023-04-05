package br.com.bluesoft.usuario.web.controller;

import br.com.bluesoft.usuario.domain.repository.UsuarioRepository;
import br.com.bluesoft.usuario.web.form.UsuarioForm;
import br.com.bluesoft.usuario.web.view.UsuarioView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public UsuarioView criarUsuario(@RequestBody UsuarioForm usuarioForm) {
        return new UsuarioView(usuarioRepository.save(usuarioForm.toEntity()));
    }

    @GetMapping
    public List<UsuarioView> listarUsuarios(@RequestParam(required = false) String nome) {
        if(nome != null && !nome.isEmpty()) {
            return UsuarioView.toView(usuarioRepository.findByNome(nome));
        }
        return UsuarioView.toView(usuarioRepository.findAll());
    }

    @DeleteMapping
    public void excluirUsuarios() {
        usuarioRepository.deleteAll();
    }

}
