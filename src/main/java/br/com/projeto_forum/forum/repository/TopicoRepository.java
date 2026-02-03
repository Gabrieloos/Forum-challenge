package br.com.projeto_forum.forum.repository;


import br.com.projeto_forum.forum.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository  extends JpaRepository<Topico,Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}