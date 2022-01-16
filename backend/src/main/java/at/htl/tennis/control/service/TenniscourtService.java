package at.htl.tennis.control.service;

import at.htl.tennis.control.TenniscourtRepository;
import at.htl.tennis.entity.Tenniscourt;

import javax.enterprise.context.ApplicationScoped;
import java.awt.print.Book;
import java.util.List;

@ApplicationScoped
public class TenniscourtService {
    private TenniscourtRepository tenniscourtRepository;

    //region constructor
    public TenniscourtService(TenniscourtRepository tenniscourtRepository) {
        this.tenniscourtRepository = tenniscourtRepository;
    }
    //endregion

    public List<Tenniscourt> getAllTenniscourts() {
        return tenniscourtRepository.findAll().stream().toList();
    }

    public Tenniscourt getTenniscourtByCourtId(int courtId) {
        return tenniscourtRepository.find("courtId", courtId).firstResult();
    }
}