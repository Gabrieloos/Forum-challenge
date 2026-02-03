package br.com.projeto_forum.forum.controller;
import br.com.projeto_forum.forum.domain.Topico;
import br.com.projeto_forum.forum.dto.*;
import br.com.projeto_forum.forum.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class ForumController {

    private final TopicoService service;

    public ForumController(TopicoService service) {
        this.service = service;
    }

    // ================= LISTAGEM =================

    @GetMapping
    public ResponseEntity<List<DadosListagemTopico>> listar() {

        var lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    // ================= DETALHAMENTO =================

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {

        var dto = service.detalhar(id);
        return ResponseEntity.ok(dto);
    }

    // ================= CADASTRO =================

    @PostMapping
    public ResponseEntity<DadosRespostaTopico> criar(
            @RequestBody @Valid DadosCriacaoTopico dados,
            UriComponentsBuilder uriBuilder
    ) {

        Topico topico = service.criar(dados);

        URI uri = uriBuilder
                .path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new DadosRespostaTopico(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosRespostaTopico> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados) {

        Topico topico = service.atualizar(id, dados);

        return ResponseEntity.ok(new DadosRespostaTopico(topico));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }


}
