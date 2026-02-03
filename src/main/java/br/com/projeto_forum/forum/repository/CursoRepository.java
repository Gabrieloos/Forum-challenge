package br.com.projeto_forum.forum.repository;

import br.com.projeto_forum.forum.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
