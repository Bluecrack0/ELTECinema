package hu.elte.inf.alkfejl.cinema.controller;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.exception.DataNotValidException;
import hu.elte.inf.alkfejl.cinema.exception.DuplicatedDataException;
import hu.elte.inf.alkfejl.cinema.exception.MissingDataException;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Reservation;
import hu.elte.inf.alkfejl.cinema.service.MovieService;
import hu.elte.inf.alkfejl.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController implements ControllerInterface<Reservation> {

    @Autowired
    private ReservationService reservationService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Reservation reservation) {
        try {
            reservationService.update(reservation);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            reservationService.deleteById(id);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Reservation reservation) {
        try {
            reservationService.delete(reservation);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Reservation reservation) {
        try {
            reservationService.create(reservation);
        } catch (DuplicatedDataException e) {
            e.printStackTrace();
        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Reservation get(@PathVariable Integer id) {
        return reservationService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @Role({ADMIN, USER})
    @GetMapping("/getAllToUser/{userId}")
    public List<Reservation> getAllToUser(@PathVariable Integer userId) {
        return reservationService.getAllReservationsToUser(userId);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getAllToScreening/{screeningId}")
    public List<Reservation> getAllToScreening(@PathVariable Integer screeningId) {
        return reservationService.getAllReservationsToScreening(screeningId);
    }

}

