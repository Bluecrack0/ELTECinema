package hu.elte.inf.alkfejl.cinema.service;


import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.ActorDao;
import hu.elte.inf.alkfejl.cinema.dao.MovieDao;
import hu.elte.inf.alkfejl.cinema.dao.ScreeningDao;
import hu.elte.inf.alkfejl.cinema.exception.DataNotValidException;
import hu.elte.inf.alkfejl.cinema.exception.DuplicatedDataException;
import hu.elte.inf.alkfejl.cinema.exception.OverLapsException;
import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Reservation;
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

    public boolean overlapsWithAny(Screening screening) {
        return screeningDao.getEntities()
                .stream()
                .anyMatch(s -> s.screeningOverLapsWith(screening));
    }

    public void createScreening(Screening screening) throws DuplicatedDataException, OverLapsException {
        if (!exist(screening)) {
            if (!overlapsWithAny(screening)) {
                screeningDao.insertEntity(screening);
            } else {
                throw new OverLapsException("Screening overlaps with another!");
            }
        } else {
            throw new DuplicatedDataException();
        }
    }

    public void updateScreening(Screening screening) throws DataNotValidException, OverLapsException {
        if (exist(screening)) {
            if (!overlapsWithAny(screening)) {
                dao.updateEntity(screening);
            } else {
                throw new OverLapsException("Screening overlaps with another!");
            }
        } else {
            throw new DataNotValidException();
        }
    }
    public void updateMovie(Integer id, Movie movie) {
        screeningDao.updateMovie(id, movie);
    }

    public void updateCinemaRoom(Integer id, CinemaRoom cinemaRoom) {
        screeningDao.updateCinemaRoom(id, cinemaRoom);
    }

    public List<Screening> getScreeningsByMovie(Integer movieId) {
        return screeningDao.getScreeningsByMovie(movieId);
    }

    public void addReservation(Integer id, Reservation reservation) {
        screeningDao.addReservationToScreening(id, reservation);
    }
}
