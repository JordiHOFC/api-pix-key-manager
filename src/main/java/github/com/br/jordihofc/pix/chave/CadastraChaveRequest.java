package github.com.br.jordihofc.pix.chave;

import github.com.br.jordihofc.pix.validators.ChaveEmFormatoValido;
import github.com.br.jordihofc.pix.validators.ExisteTipoDeChave;
import github.com.br.jordihofc.pix.validators.ExisteTipoDeConta;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CadastraChaveRequest {
    @ExisteTipoDeChave
    @NotBlank
    private String tipo;

    @ChaveEmFormatoValido
    @Length(max = 77)
    private String chave;

    @ExisteTipoDeConta
    @NotBlank
    private String conta;

    @NotNull
    private UUID idCliente;

    public CadastraChaveRequest(String tipo, String chave, String conta, UUID idCliente) {
        this.tipo = tipo;
        this.chave = chave;
        this.conta = conta;
        this.idCliente = idCliente;
    }

    @Deprecated
    public CadastraChaveRequest() {
    }

    public Chave paraChave(ChaveRepository repository) {

        if (repository.existsByChave(chave)) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Chave já cadastrada no sistema.");
        }

        return new Chave(
                idCliente,
                TipoChave.valueOf(tipo),
                chave != null ? chave : UUID.randomUUID().toString(),
                TipoConta.valueOf(conta)
        );

    }


    public String getTipo() {
        return tipo;
    }

    public String getChave() {
        return chave;
    }

    public String getConta() {
        return conta;
    }

    public UUID getIdCliente() {
        return idCliente;
    }
}
