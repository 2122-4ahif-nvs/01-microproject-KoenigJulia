package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.context.api.CurrentThreadContext;

import javax.persistence.*;

@NamedQueries(
        @NamedQuery(
        name = "Member.findMemberByMember",
        query = "select m from Member m where m.isTrainer = :TRAINER and m.mail = :MAIL " +
                "and m.name = :NAME and m.phoneNumber = :PHONENUMBER"
        )
)
@Entity
@Table(name = "TC_MEMBER")
public class Member extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "M_NAME")
    public String name;

    @Column(name = "M_MAIL")
    public String mail;

    @Column(name = "M_PHONENUMBER")
    public String phoneNumber;

    @Column(name = "M_TRAINER")
    public Boolean isTrainer;

    //region constructors
    public Member(String name, String mail, String phoneNumber, Boolean isTrainer) {
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.isTrainer = isTrainer;
    }

    public Member() {
    }
    //endregions

    //region toString
    @Override
    public String toString() {
        return "id=" + id +
                ", name= " + name + '\'' +
                ", mail= " + mail + '\'' +
                ", phoneNumber= " + phoneNumber + '\'' +
                '}';
    }
    //endregion
}
