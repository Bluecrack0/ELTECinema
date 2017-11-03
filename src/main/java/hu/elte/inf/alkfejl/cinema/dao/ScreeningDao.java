package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Screening;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class ScreeningDao extends GenericDaoImpl<Screening> {
    public ScreeningDao(Class<Screening> screeningClass, SessionFactory sessionFactor) {
        super(screeningClass, sessionFactor);
    }

    public void updateCinemaRoom(Integer id, CinemaRoom cinemaRoom) {
        Screening screening = findEntity(id);
        screening.setCinemaRoom(cinemaRoom);
        updateEntity(screening);
    }

    public void updateMovie(Integer id, Movie movie) {
        Screening screening = findEntity(id);
        screening.setMovie(movie);
        updateEntity(screening);
    }

    public List<Screening> getScreeningsByMovie(Movie movie) {
        Query query = currentSession().createQuery("SELECT s FROM Movie m JOIN m.screenings s WHERE m.id = :movieId");
        query.setParameter("movieId", movie.getId());
        return (List<Screening>) query.list();
    }
}
