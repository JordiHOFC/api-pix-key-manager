package github.com.br.jordihofc.pix.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExisteTipoChaveValidator.class)
public @interface ExisteTipoDeChave {
    String message() default "deve pertencer a um dos seguintes tipos: CELULAR, EMAIL, CPF, ALEATORIA";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
