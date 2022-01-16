package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@NamedQueries(
        @NamedQuery(
                name = "Tenniscourt.getTenniscourtByTenniscourt",
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

    @Column(name = "TE_ISPLAYABLE")
    public boolean isPlayable;

    //region constructor
    public Tenniscourt(Integer courtId, boolean isPlayable) {
        this.courtId = courtId;
        this.isPlayable = isPlayable;
    }

    public Tenniscourt() {
    }
    //endregion
    //region toString
    @Override
    public String toString() {
        return "Tenniscourt{" +
                "id=" + id +
                ", courtId=" + courtId +
                ", isPlayable=" + isPlayable +
                '}';
    }
    //endregion
}
