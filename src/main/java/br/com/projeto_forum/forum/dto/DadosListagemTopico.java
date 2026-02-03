package br.com.projeto_forum.forum.dto;

import br.com.projeto_forum.forum.domain.StatusTopico;
import br.com.projeto_forum.forum.domain.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso

) {

    public DadosListagemTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getNome(),
                topico.getCurso().getCategoria()
        );
    }
}
