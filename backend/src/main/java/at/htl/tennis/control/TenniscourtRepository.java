package at.htl.tennis.control;

import at.htl.tennis.entity.Tenniscourt;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class TenniscourtRepository implements PanacheRepository<Tenniscourt> {

    @Inject
    EntityManager em;

    @Transactional
    public Tenniscourt save(Tenniscourt court) {
        Tenniscourt tenniscourt = getTenniscourtByTenniscourt(court);
        if(tenniscourt != null)
            return tenniscourt;
        return em.merge(court);
    }

    public Tenniscourt getTenniscourtByTenniscourt(Tenniscourt court) {
        TypedQuery<Tenniscourt> query = em.createNamedQuery("Tenniscourt.getTenniscourtByTenniscourt",Tenniscourt.class)
                .setParameter("COURTID", court.courtId);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
