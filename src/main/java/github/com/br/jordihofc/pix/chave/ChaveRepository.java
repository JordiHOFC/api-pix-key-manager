package github.com.br.jordihofc.pix.chave;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChaveRepository extends JpaRepository<Chave,Long> {
    boolean existsByChave(String chave);
}
