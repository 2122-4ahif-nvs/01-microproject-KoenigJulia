package at.htl.tennis.control;

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
public class TrainingssessionRepository implements PanacheRepository<Trainingssession> {
    @Inject
    EntityManager em;

    @Transactional
    public Trainingssession save(Trainingssession session) {
        Trainingssession trainingssession = findTrainingssessionByTrainingssession(session);
        if(trainingssession != null)
            return trainingssession;
        return em.merge(session);
    }

    private Trainingssession findTrainingssessionByTrainingssession(Trainingssession session) {
        TypedQuery<Trainingssession> query = em.createNamedQuery("Trainingssession.findTrainingssessionByTrainingssession",Trainingssession.class)
                .setParameter("TRAININGSTIME", session.trainingsTime)
                .setParameter("TENNISCOURT", session.tenniscourt);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
