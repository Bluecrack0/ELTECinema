package hu.elte.inf.alkfejl.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements ModelInterface, Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    @Getter @Setter private String username;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Getter @Setter private String email;

    @Column(name = "PASSWORD", nullable = false)
    @Getter @Setter private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    @Getter @Setter private Role role;

    @OneToMany(targetEntity = Reservation.class, mappedBy = "owner")
    @Getter @Setter private List<Reservation> reservationList;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public enum Role {
        GUEST, USER, ADMIN
    }
}
