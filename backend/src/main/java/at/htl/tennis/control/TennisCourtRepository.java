package at.htl.tennis.control;

import at.htl.tennis.entity.Tenniscourt;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TennisCourtRepository implements PanacheRepository<Tenniscourt> {
}
