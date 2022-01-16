package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "Match.findMatchByMatch",
                query = "select m from Match m where m.startTime = :STARTTIME and m.endTime = :ENDTIME and m.tenniscourt = :TENNISCOURT "
        )
)
@Entity
@Table(name = "TC_MATCH")
public class Match extends PanacheEntityBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "MA_TE_ID")
    public Tenniscourt tenniscourt;

    @Column(name = "MA_STARTTIME")
    public LocalDateTime startTime;

    @Column(name = "MA_ENDTIME")
    public LocalDateTime endTime;

/*
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    public List<MatchPlan> matchPlans;
*/

    //region constructor
    public Match(Tenniscourt tenniscourt, LocalDateTime startTime, LocalDateTime endTime) {
        this.tenniscourt = tenniscourt;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Match() {
    }
    //endregion
    //region toString
    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", tenniscourt=" + tenniscourt +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
    //endregion
}
