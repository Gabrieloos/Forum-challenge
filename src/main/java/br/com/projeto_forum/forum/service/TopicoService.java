package br.com.projeto_forum.forum.service;

import br.com.projeto_forum.forum.domain.Topico;
import br.com.projeto_forum.forum.dto.*;
import br.com.projeto_forum.forum.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    // ================= LISTAR =================

    public List<DadosListagemTopico> listar() {
        return repository.findAll()
                .stream()
                .map(DadosListagemTopico::new)
                .toList();
    }

    // ================= DETALHAR =================

    public DadosDetalhamentoTopico detalhar(Long id) {
        Topico topico = repository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    // ================= CRIAR =================

    public Topico criar(DadosCriacaoTopico dados) {

        Topico topico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                null, // depois ligamos autor
                null  // depois ligamos curso
        );

        repository.save(topico);
        return topico;
    }

    // ================= ATUALIZAR =================

    public Topico atualizar(Long id, DadosAtualizacaoTopico dados) {

        Topico topico = repository.getReferenceById(id);

        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());

        return topico;
    }
    public void excluir(Long id) {

        var existe = repository.existsById(id);

        if (!existe) {
            throw new RuntimeException("Tópico não encontrado");
        }

        repository.deleteById(id);
    }

}
