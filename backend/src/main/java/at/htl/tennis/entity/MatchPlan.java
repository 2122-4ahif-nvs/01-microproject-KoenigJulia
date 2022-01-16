package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "MatchPlan.getMatchPlanByMatchPlan",
                query = "select mp from MatchPlan mp where mp.match = :MATCH and mp.member = :MEMBER"
        ),
        @NamedQuery(
                name = "MatchPlan.getMatchPlansByMatchId",
                query = "select mp from MatchPlan mp where mp.match.id = :MATCHID"
        )
})
@Entity
@Table(name = "TC_MATCHPLAN")
public class MatchPlan extends PanacheEntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "MP_ME_ID")
    public Member member;

    @ManyToOne
    @JoinColumn(name = "MP_MA_ID")
    public Match match;

    //region constructor
    public MatchPlan(Member member, Match match) {
        this.member = member;
        this.match = match;
    }

    public MatchPlan() {

    }
    //endregion
    //region toString
    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", member=" + member +
                ", match=" + match +
                '}';
    }
    //endregion
}
