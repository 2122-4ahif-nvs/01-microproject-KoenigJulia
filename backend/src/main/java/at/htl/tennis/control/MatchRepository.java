package at.htl.tennis.control;

import at.htl.tennis.entity.Match;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MatchRepository implements PanacheRepository<Match> {
    @Inject
    EntityManager em;

    @Transactional
    public Match save(Match match) {
        Match match1 = getMatchByMatch(match);
        if(match1 != null)
            return match1;
        return em.merge(match);
    }

    public Match getMatchByMatch(Match match) {
        TypedQuery<Match> query = em.createNamedQuery("Match.findMatchByMatch",Match.class)
                .setParameter("STARTTIME", match.startTime)
                .setParameter("ENDTIME", match.endTime)
                .setParameter("TENNISCOURT", match.tenniscourt);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }

    public List<Match> getAllMatches() {
        return this.findAll().stream().toList();
    }
}
