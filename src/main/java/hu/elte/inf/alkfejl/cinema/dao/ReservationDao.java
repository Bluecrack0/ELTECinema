package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Reservation;
import org.hibernate.SessionFactory;

public class ReservationDao extends GenericDaoImpl<Reservation> {

    public ReservationDao(Class<Reservation> reservationClass, SessionFactory sessionFactor) {
        super(reservationClass, sessionFactor);
    }
}
