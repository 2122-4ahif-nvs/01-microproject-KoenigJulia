package at.htl.tennis;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoCussesValidator implements ConstraintValidator<NoCussesConstraint, String> {

    @Override
    public void initialize(NoCussesConstraint words) {
    }

    @Override
    public boolean isValid(String text,
                           ConstraintValidatorContext cxt) {
        return text != null
                && !text.toLowerCase().contains("nichtsnutz")
                && !text.toLowerCase().contains("trampel")
                && !text.toLowerCase().contains("hohlkopf");
    }
}
