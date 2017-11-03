package hu.elte.inf.alkfejl.cinema.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table (name = "ROOMS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CinemaRoom implements ModelInterface {

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "ROWS", nullable = false)
    @Getter @Setter private Integer rows;

    @Column(name = "COLUMNS", nullable = false)
    @Getter @Setter private Integer columns;

    @OneToOne(mappedBy = "cinemaRoom")
    @Getter @Setter private Screening screening;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }
}
