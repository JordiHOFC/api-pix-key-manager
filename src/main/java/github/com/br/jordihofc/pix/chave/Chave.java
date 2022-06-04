package github.com.br.jordihofc.pix.chave;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Chave {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private UUID idCliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoChave tipo;

    @Column(nullable = false, unique = true, length = 77)
    private String chave;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConta conta;

    @Column(nullable = false)
    private LocalDateTime criadoEm= LocalDateTime.now();

    public Chave(UUID idCliente, TipoChave tipo, String chave, TipoConta conta) {
        this.idCliente = idCliente;
        this.tipo = tipo;
        this.chave = chave;
        this.conta = conta;
    }

    @Deprecated
    public Chave() {
    }

    public Long getId() {
        return id;
    }
}
