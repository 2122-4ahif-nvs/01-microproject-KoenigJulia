package at.htl.tennis.control;

import at.htl.tennis.entity.Member;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class MemberRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Member save(Member person) {
        return em.merge(person);
    }
}
