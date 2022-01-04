package at.htl.tennis;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoCussesValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoCussesConstraint {
    String message() default "Cusses";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
