package hu.elte.inf.alkfejl.cinema.controller;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.CinemaRoomDao;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@RestController
@RequestMapping("/api/cinemarooms")
public class CinemaRoomController implements ControllerInterface<CinemaRoom>{

    @Autowired
    private CinemaRoomService cinemaRoomService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody CinemaRoom cinemaRoom) {
        cinemaRoomService.update(cinemaRoom);
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        cinemaRoomService.deleteById(id);
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(CinemaRoom cinemaRoom) {
        cinemaRoomService.delete(cinemaRoom);
    }

    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody CinemaRoom cinemaRoom) {
        cinemaRoomService.create(cinemaRoom);
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public CinemaRoom get(@PathVariable Integer id) {
        return cinemaRoomService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<CinemaRoom> getAll() {
        return cinemaRoomService.getAll();
    }

}
