package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@NamedQueries(
        @NamedQuery(
                name = "Tenniscourt.findTenniscourtByTenniscourt",
                query = "select t from Tenniscourt t where t.courtId = :COURTID"
        )
)
@Entity
@Table(name = "TC_TENNISCOURT")
public class Tenniscourt extends PanacheEntityBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "TE_CourtID")
    public Integer courtId;
}
