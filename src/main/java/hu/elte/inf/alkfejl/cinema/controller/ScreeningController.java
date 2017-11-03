package hu.elte.inf.alkfejl.cinema.controller;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.CinemaRoomDao;
import hu.elte.inf.alkfejl.cinema.dao.ScreeningDao;
import hu.elte.inf.alkfejl.cinema.exception.DataNotValidException;
import hu.elte.inf.alkfejl.cinema.exception.DuplicatedDataException;
import hu.elte.inf.alkfejl.cinema.exception.MissingDataException;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Screening;
import hu.elte.inf.alkfejl.cinema.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController implements ControllerInterface<Screening>{

    @Autowired
    private ScreeningService screeningService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Screening screening) {
        try {
            screeningService.update(screening);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            screeningService.deleteById(id);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Screening screening) {
        try {
            screeningService.delete(screening);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Screening screening) {
        try {
            screeningService.create(screening);
        } catch (DuplicatedDataException e) {
            e.printStackTrace();
        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Screening get(@PathVariable Integer id) {
        return screeningService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Screening> getAll() {
        return screeningService.getAll();
    }

    @Role({ADMIN})
    @GetMapping("/updateMovie/{id}")
    public void updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {

        screeningService.updateMovie(id, movie);
    }

    @PostMapping("/updateCinemaRoom/{id}")
    @Role(ADMIN)
    public void updateCinemaRoom(@PathVariable Integer id, @RequestBody CinemaRoom cinemaRoom) {
        screeningService.updateCinemaRoom(id, cinemaRoom);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getAllByMovie")
    public List<Screening> getScreeningsByMovie(@RequestBody Movie movie) {
        return screeningService.getScreeningsByMovie(movie);
    }
}
