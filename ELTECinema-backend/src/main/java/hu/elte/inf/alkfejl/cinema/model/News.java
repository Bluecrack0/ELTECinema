package hu.elte.inf.alkfejl.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "News")
@Table(name = "NEWS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News implements ModelInterface {

    @Id
    @Column(name = "NEWS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "TITLE", nullable = false)
    @Getter @Setter private String title;

    @Column(name = "ARTICLE", nullable = false)
    @Getter @Setter private String article;

    @Column(name = "PUBTIME", nullable = false)
    @Getter @Setter private String pubtime;

}