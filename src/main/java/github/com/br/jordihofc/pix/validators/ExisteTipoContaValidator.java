package github.com.br.jordihofc.pix.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteTipoContaValidator implements ConstraintValidator<ExisteTipoDeConta, String> {

    @Override
    public boolean isValid(String tipo, ConstraintValidatorContext context) {
        List<String> tipos = List.of(
                "CONTA_CORRENTE",
                "CONTA_POUPANCA"
        );

        return tipos.contains(tipo);
    }
}
