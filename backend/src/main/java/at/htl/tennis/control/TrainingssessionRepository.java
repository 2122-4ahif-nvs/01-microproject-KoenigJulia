package at.htl.tennis.control;

import at.htl.tennis.entity.Trainingssession;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingssessionRepository implements PanacheRepository<Trainingssession> {
}
