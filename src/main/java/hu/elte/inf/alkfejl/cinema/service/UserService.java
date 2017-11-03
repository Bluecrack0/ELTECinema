package hu.elte.inf.alkfejl.cinema.service;

import hu.elte.inf.alkfejl.cinema.dao.UserDao;
import hu.elte.inf.alkfejl.cinema.exception.UserNotValidException;
import hu.elte.inf.alkfejl.cinema.model.Reservation;
import hu.elte.inf.alkfejl.cinema.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService extends AbstractService<User> {

    @Autowired
    private UserDao userDao;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userDao.findByUsername(user.getUsername());
        }
        throw new UserNotValidException("Username already exists!");
    }

    public void logout() {
        user = null;
    }

    public void register(User user) {
        userDao.insertEntity(user);
        this.user = userDao.findByUsername(user.getUsername());
    }

    public boolean isValid(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public User getLoggedInUser() {
        return user;
    }

    public void addReservation(Integer userId, Reservation reservation) {
        userDao.addReservationToUser(userId, reservation);
    }
}
