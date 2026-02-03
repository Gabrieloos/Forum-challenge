package br.com.projeto_forum.forum.dto;

import br.com.projeto_forum.forum.domain.Topico;
import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(

        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String autor,
        String curso

) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus().name(),
                topico.getAutor().getNome(),
                topico.getCurso().getCategoria()
        );
    }
}

