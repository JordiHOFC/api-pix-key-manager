package github.com.br.jordihofc.pix.chave;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarChaveController {
    private final ChaveRepository repository;

    public CadastrarChaveController(ChaveRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/chaves")
    @Transactional
    public ResponseEntity<?> cadastrar(
            @RequestBody @Valid CadastraChaveRequest request, UriComponentsBuilder uriComponentsBuilder
    ) {
        Chave chave = request.paraChave(repository);

        repository.save(chave);

        URI location = uriComponentsBuilder.path("/chaves/{id}")
                .buildAndExpand(chave.getId())
                .toUri();


        return ResponseEntity.created(location).build();
    }
}
