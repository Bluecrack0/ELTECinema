package hu.elte.inf.alkfejl.cinema.service;


import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.ActorDao;
import hu.elte.inf.alkfejl.cinema.dao.MovieDao;
import hu.elte.inf.alkfejl.cinema.dao.ScreeningDao;
import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Screening;
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
public class ScreeningService extends AbstractService<Screening> {

    @Autowired
    MovieDao movieDao;

    @Autowired
    private ActorDao actorDao;

    @Autowired
    private ScreeningDao screeningDao;

    public void updateMovie(Integer id, Movie movie) {
        screeningDao.updateMovie(id, movie);
    }

    public void updateCinemaRoom(Integer id, CinemaRoom cinemaRoom) {
        screeningDao.updateCinemaRoom(id, cinemaRoom);
    }

    public List<Screening> getScreeningsByMovie(Movie movie) {
        return screeningDao.getScreeningsByMovie(movie);
    }
}
