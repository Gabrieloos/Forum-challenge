package br.com.projeto_forum.forum.repository;

import br.com.projeto_forum.forum.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
