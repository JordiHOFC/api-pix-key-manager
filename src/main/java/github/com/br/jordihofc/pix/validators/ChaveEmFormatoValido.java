package github.com.br.jordihofc.pix.validators;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@ConstraintComposition(CompositionType.OR)
@CPF
@ReportAsSingleViolation
@Email
@Pattern(regexp = "^\\+[1-9][0-9]\\d{1,14}$")
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface ChaveEmFormatoValido {
    String message() default "deve estar em um formato valido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
