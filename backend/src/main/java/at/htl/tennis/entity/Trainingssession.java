package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "Trainingssession.findTrainingssessionByTrainingssession",
                query = "select t from Trainingssession t where t.tenniscourt = :TENNISCOURT and t.trainingsTime = :TRAININGSTIME"
        )
)
@Entity
@Table(name = "TC_TRAININGSSESSION")
public class Trainingssession extends PanacheEntityBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "TS_TE_ID")
    public Tenniscourt tenniscourt;

    @Column(name = "TS_TRAININGSTIME")
    public LocalDateTime trainingsTime;

}
