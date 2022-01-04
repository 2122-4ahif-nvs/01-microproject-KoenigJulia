package at.htl.tennis.control;

import at.htl.tennis.entity.Match;
import at.htl.tennis.entity.MatchPlan;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class MatchPlanRepository implements PanacheRepository<MatchPlan> {
    @Inject
    EntityManager em;

    @Transactional
    public MatchPlan save(MatchPlan matchPlan) {
        MatchPlan savedMatchPlan = findMatchByMatch(matchPlan);
        if(savedMatchPlan != null)
            return savedMatchPlan;
        return em.merge(matchPlan);
    }

    public MatchPlan findMatchByMatch(MatchPlan matchPlan) {
        TypedQuery<MatchPlan> query = em.createNamedQuery("MatchPlan.findMatchPlanByMatchPlan",MatchPlan.class)
                .setParameter("MATCH", matchPlan.match)
                .setParameter("MEMBER", matchPlan.member);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
