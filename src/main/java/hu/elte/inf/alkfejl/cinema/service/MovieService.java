package hu.elte.inf.alkfejl.cinema.service;


import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.ActorDao;
import hu.elte.inf.alkfejl.cinema.dao.MovieDao;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class MovieService extends AbstractService<Movie> {

    @Autowired
    MovieDao movieDao;

    @Autowired
    ActorDao actorDao;


    public List<Movie> getMoviesByActor(Integer actorId) {
        return movieDao.getMoviesByActor(actorId);
    }

    public void addActorToMovie(Integer id, Integer actorid) {
        movieDao.addActorToMovie(id, actorDao.findEntity(actorid));
    }
}
