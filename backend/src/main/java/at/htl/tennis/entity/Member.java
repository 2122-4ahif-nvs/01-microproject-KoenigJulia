package at.htl.tennis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NamedQueries(
        @NamedQuery(
        name = "Member.findMemberByMember",
        query = "select m from Member m where m.mail = :MAIL " +
                "and m.firstname = :FIRSTNAME and m.lastname = :LASTNAME and m.phoneNumber = :PHONENUMBER"
        )
)
@Entity
@Table(name = "TC_MEMBER")
public class Member extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "Firstname may not be blank")
    @Column(name = "ME_FIRSTNAME")
    public String firstname;

    @NotBlank(message = "Lastname may not be blank")
    @Column(name = "ME_LASTNAME")
    public String lastname;

    @NotBlank(message = "Email may not be blank")
    @Column(name = "ME_MAIL")
    public String mail;

    @Column(name = "ME_PHONENUMBER")
    public String phoneNumber;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<MatchPlan> matchPlans;


    //region constructors
    public Member(String firstname, String lastname, String mail, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Member() {
    }

    public Member(String firstname, String lastname, String mail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
    }
    //endregions
    //region toString
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    //endregion
}
