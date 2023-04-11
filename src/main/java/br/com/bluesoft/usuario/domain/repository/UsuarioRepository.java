package br.com.bluesoft.usuario.domain.repository;

import br.com.bluesoft.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public List<Usuario> findByNome(String nome);

}
