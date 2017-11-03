package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import org.hibernate.SessionFactory;

public class CinemaRoomDao extends GenericDaoImpl<CinemaRoom> {

    public CinemaRoomDao(Class<CinemaRoom> cinemaRoomClass, SessionFactory sessionFactor) {
        super(cinemaRoomClass, sessionFactor);
    }
}
