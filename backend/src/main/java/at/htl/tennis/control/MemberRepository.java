package at.htl.tennis.control;

import at.htl.tennis.entity.Member;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class MemberRepository implements PanacheRepository<Member> {

    @Inject
    EntityManager em;

    @Transactional
    public Member save(Member person) {
        Member member = findMemberByMember(person);
        if(member != null)
            return member;
        return em.merge(person);
    }

    public Member findMemberByMember(Member person) {
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
}
