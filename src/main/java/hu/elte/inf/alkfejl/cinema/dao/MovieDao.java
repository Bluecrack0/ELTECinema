package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Screening;
import hu.elte.inf.alkfejl.cinema.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieDao extends GenericDaoImpl<Movie> {

    public MovieDao(Class<Movie> movieClass, SessionFactory sessionFactor) {
        super(movieClass, sessionFactor);
    }

    public List<Movie> getMoviesByActor(Integer actorId) {
        Query query = currentSession().createQuery("SELECT m FROM Movie m JOIN m.actors a WHERE a.id = :actorId");
        query.setParameter("actorId", actorId);
        return (List<Movie>) query.list();
    }

    public void addActorToMovie(Integer movieId, Actor actor) {
        Movie movie = findEntity(movieId);
        movie.getActors().add(actor);
        updateEntity(movie);
    }

    public void addScreeningToMovie(Integer movieId, Screening screening) {
        Movie movie = findEntity(movieId);
        movie.getScreenings().add(screening);
        updateEntity(movie);
    }
}
