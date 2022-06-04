package github.com.br.jordihofc.pix.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExisteTipoContaValidator.class)
public @interface ExisteTipoDeConta {
    String message() default "deve pertencer a um dos seguintes tipos: CONTA_CORRENTE OU CONTA_POUPANCA";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
