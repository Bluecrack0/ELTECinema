package hu.elte.inf.alkfejl.cinema.dao;

import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class UserDao extends GenericDaoImpl<User> {
    public UserDao(Class<User> userClass, SessionFactory sessionFactor) {
        super(userClass, sessionFactor);
    }

    public User findByUsername(String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.eq("username", username));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (User) executableCriteria.uniqueResult();
    }

    public User findByUsernameAndPassword(String username, String password) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (User) executableCriteria.uniqueResult();
    }
}
