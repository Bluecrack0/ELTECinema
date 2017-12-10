package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.News;
import hu.elte.inf.alkfejl.cinema.model.User;
import org.hibernate.SessionFactory;

public class NewsDao extends GenericDaoImpl<News> {

    public NewsDao(Class<News> userClass, SessionFactory sessionFactor) {
        super(userClass, sessionFactor);
    }
}


