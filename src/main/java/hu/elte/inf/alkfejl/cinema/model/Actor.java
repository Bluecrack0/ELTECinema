package hu.elte.inf.alkfejl.cinema.model;

//import org.h2.store.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Actor")
@Table(name = "ACTORS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor implements ModelInterface {

    @Id
    @Column(name = "ACTOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "NAME", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "SEX", nullable = false)
    @Getter @Setter private String sex;

    @Column(name = "AGE", nullable = false)
    @Getter @Setter private Integer age;

    @Column(name = "BIO", nullable = false)
    @Getter @Setter private String bio;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "ACTOR_MOVIE", joinColumns = {
            @JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "ACTOR_ID",
                    nullable = false, updatable = false) })
    @JsonIgnore
    @Getter @Setter private List<Movie> movies;
}
