package github.com.br.jordihofc.pix.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteTipoChaveValidator implements ConstraintValidator<ExisteTipoDeChave, String> {

    @Override
    public boolean isValid(String tipo, ConstraintValidatorContext context) {
        List<String> tipos = List.of(
                "EMAIL",
                "CELULAR",
                "ALEATORIA",
                "CPF"
        );


        return tipos.contains(tipo);
    }
}
