package hu.elte.inf.alkfejl.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_RESERVATIONS", joinColumns = {
            @JoinColumn(name = "RESERVATION_ID", nullable = false, updatable = false) })
    @JsonIgnore
    @Getter @Setter private User owner;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "SCREENING_RESERVATIONS", joinColumns = {
            @JoinColumn(name = "RESERVATION_ID", nullable = false, updatable = false) })
    @JsonIgnore
    @Getter @Setter private Screening screening;

    @Column(name = "ROW", nullable = false)
    @Getter @Setter private Integer row;

    @Column(name = "COL", nullable = false)
    @Getter @Setter private Integer col;
}
