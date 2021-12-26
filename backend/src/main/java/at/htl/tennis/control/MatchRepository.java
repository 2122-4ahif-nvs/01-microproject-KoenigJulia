package at.htl.tennis.control;

import at.htl.tennis.entity.Match;
import at.htl.tennis.entity.Member;
import at.htl.tennis.entity.Trainingssession;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class MatchRepository implements PanacheRepository<Match> {
    @Inject
    EntityManager em;

    @Transactional
    public Match save(Match match) {
        Match match1 = findMatchByMatch(match);
        if(match1 != null)
            return match1;
        return em.merge(match);
    }

    private Match findMatchByMatch(Match match) {
        TypedQuery<Match> query = em.createNamedQuery("Match.findMatchByMatch",Match.class)
                .setParameter("PLAYTIME", match.playTime)
                .setParameter("TENNISCOURT", match.tenniscourt);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
