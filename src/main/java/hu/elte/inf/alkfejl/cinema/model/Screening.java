package hu.elte.inf.alkfejl.cinema.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "SCREENING")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Screening implements ModelInterface, Comparable<Screening> {

    @Id
    @Column(name = "SCREENING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "SCREENING_MOVIE", joinColumns = {
            @JoinColumn(name = "SCREENING_ID", nullable = false, updatable = false) })
    @Getter @Setter private Movie movie;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "SCREENING_ROOM")
    @Getter @Setter private CinemaRoom cinemaRoom;

    @Column(name = "START_TIME", nullable = false)
    @Getter @Setter private Date startTime;

    @Column(name = "END_TIME", nullable = false)
    @Getter @Setter private Date endTime;

    @Override
    public int compareTo(Screening otherScreening) {
        return this.getEndTime().compareTo(otherScreening.getStartTime());
    }

    public boolean screeningOverLapsWith(Screening otherScreening) {
        return this.compareTo(otherScreening) >= 1;
    }
}
