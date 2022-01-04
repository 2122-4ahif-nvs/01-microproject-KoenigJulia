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

    @Inject
    MemberRepository memberRepository;

    //region constructor
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //endregion

    public Member getMemberByMember(Member member){
        return memberRepository.findMemberByMember(member);
    }

    public void validateMember(@Valid Member member){
        validator.validate(member);
    }
}
