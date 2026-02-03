package br.com.projeto_forum.forum.dto;

import br.com.projeto_forum.forum.domain.Topico;
import java.time.LocalDateTime;

public record DadosRespostaTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {
    public DadosRespostaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }
}
