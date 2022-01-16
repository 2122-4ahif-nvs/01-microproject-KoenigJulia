package at.htl.tennis.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NamedQueries(
        @NamedQuery(
                name = "Member.getMemberByMember",
                query = "select m from Member m where m.mail = :MAIL " +
                        "and m.firstname = :FIRSTNAME and m.lastname = :LASTNAME and m.phoneNumber = :PHONENUMBER"
        )
)
@Entity
@UserDefinition
@Table(name = "TC_MEMBER")
public class Member extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "Firstname may not be blank")
    @Column(name = "ME_FIRSTNAME")
    @Username
    public String firstname;

    @NotBlank(message = "Lastname may not be blank")
    @Column(name = "ME_LASTNAME")
    public String lastname;

    @NotBlank(message = "Email may not be blank")
    @Column(name = "ME_MAIL")
    public String mail;

    @Column(name = "ME_PHONENUMBER")
    public String phoneNumber;

    @Column(name = "ME_PASSWORD")
    @Password
    public String password;

    @Column(name = "ME_ROLE")
    @Roles
    public String role;

/*
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    public List<MatchPlan> matchPlans;
*/


    //region constructors
    public Member() {
    }

    public Member(String firstname, String lastname, String mail, String phoneNumber, String password, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.password = BcryptUtil.bcryptHash(password);
        this.role = role;
    }

    public Member(String firstname, String lastname, String mail, String password, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = BcryptUtil.bcryptHash(password);
        this.role = role;
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
