package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "Match.findMatchByMatch",
                query = "select m from Match m where m.playTime = :PLAYTIME and m.tenniscourt = :TENNISCOURT "
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

    @Column(name = "MA_PLAYTIME")
    public LocalDateTime playTime;
}
