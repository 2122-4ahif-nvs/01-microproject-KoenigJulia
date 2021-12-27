package at.htl.tennis.control;

import at.htl.tennis.entity.Member;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;

@ApplicationScoped
public class MemberService {
    @Inject
    Validator validator;

    public void validateMember(@Valid Member member){
        validator.validate(member);
    }
}
