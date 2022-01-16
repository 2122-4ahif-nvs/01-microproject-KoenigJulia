package at.htl.tennis.control;

import at.htl.tennis.entity.Member;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@ApplicationScoped
public class MemberRepository implements PanacheRepository<Member> {

    @Inject
    EntityManager em;

    @Inject
    Validator validator;


    public void validateMember(@Valid Member member){
        validator.validate(member);
    }

    @Transactional
    public Member save(Member person) {
        Member member = getMemberByMember(person);
        if(member != null)
            return member;
        return em.merge(person);
    }

    public Member getMemberByMember(Member person) {
        TypedQuery<Member> query = em.createNamedQuery("Member.findMemberByMember",Member.class)
                .setParameter("MAIL", person.mail)
                .setParameter("FIRSTNAME", person.firstname)
                .setParameter("LASTNAME", person.lastname)
                .setParameter("PHONENUMBER", person.phoneNumber);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }

    public List<Member> getAllMember() {
        return this.findAll().stream().toList();
    }
}
