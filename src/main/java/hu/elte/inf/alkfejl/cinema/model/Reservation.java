package hu.elte.inf.alkfejl.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.ui.Model;

import javax.persistence.*;

@Entity(name = "Reservation")
@Table(name = "RESERVATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation implements ModelInterface {

    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @JoinColumn
    @ManyToOne(targetEntity = User.class, optional = false)
    @JsonIgnoreProperties("reservationList")
    @Getter @Setter private User owner;

    @JoinColumn
    @ManyToOne(targetEntity = Screening.class, optional = false)
    @JsonIgnoreProperties("reservations")
    @Getter @Setter private Screening screening;

    @Column(name = "ROW", nullable = false)
    @Getter @Setter private Integer row;

    @Column(name = "COL", nullable = false)
    @Getter @Setter private Integer col;
}
