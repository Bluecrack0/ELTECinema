package hu.elte.inf.alkfejl.cinema;

import hu.elte.inf.alkfejl.cinema.config.DaoConfigTest;
import hu.elte.inf.alkfejl.cinema.config.DatabaseConfigTest;
import hu.elte.inf.alkfejl.cinema.config.TestApplicationContext;
import hu.elte.inf.alkfejl.cinema.controller.*;
import hu.elte.inf.alkfejl.cinema.dao.*;
import hu.elte.inf.alkfejl.cinema.enums.AgeLimit;
import hu.elte.inf.alkfejl.cinema.model.*;
import hu.elte.inf.alkfejl.cinema.service.*;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTests {

	@Autowired
	ActorDao actorDao;
	@Autowired
	CinemaRoomDao cinemaRoomDao;
	@Autowired
	MovieDao movieDao;
	@Autowired
	NewsDao newsDao;
	@Autowired
	ReservationDao reservationDao;
	@Autowired
	ScreeningDao screeningDao;
	@Autowired
	UserDao userDao;

    @Autowired
    ActorService actorService;
    @Autowired
    CinemaRoomService cinemaRoomService;
    @Autowired
    MovieService movieService;
    @Autowired
    NewsService newsService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    ScreeningService screeningService;
    @Autowired
    UserService userService;

    @Autowired
    ActorController actorController;
    @Autowired
    CinemaRoomController cinemaRoomController;
    @Autowired
    MovieController movieController;
    @Autowired
    NewsController newsController;
    @Autowired
    ReservationController reservationController;
    @Autowired
    ScreeningController screeningController;
    @Autowired
    UserController userController;

    @Test
	public void contextLoads() {
		DaoConfigTest daoConfigTest = new DaoConfigTest();
		DatabaseConfigTest databaseConfigTest = new DatabaseConfigTest();
		TestApplicationContext testApplicationContext = new TestApplicationContext();
	}

	@Test(expected = ConstraintViolationException.class)
	public void daoTests() {
        new DaoTest(actorDao, cinemaRoomDao, movieDao, newsDao, reservationDao, screeningDao, userDao).daoTests();
    }

    @Test
    public void serviceTests() {
        new ServiceTest(actorService, cinemaRoomService, movieService, newsService, reservationService, screeningService, userService).serviceTests();
    }

    @Test
    public void controllerTests() throws Exception {
        new ControllerTest(actorController, cinemaRoomController, movieController, newsController, reservationController, screeningController, userController).controllerTests();
    }
}
