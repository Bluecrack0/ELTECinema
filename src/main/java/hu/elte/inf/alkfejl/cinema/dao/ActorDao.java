package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.Screening;
import org.hibernate.SessionFactory;

public class ActorDao extends GenericDaoImpl<Actor> {
    public ActorDao(Class<Actor> actorClass, SessionFactory sessionFactor) {
        super(actorClass, sessionFactor);
    }
}
