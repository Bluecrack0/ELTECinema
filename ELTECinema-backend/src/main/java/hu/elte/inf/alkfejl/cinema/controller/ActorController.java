package hu.elte.inf.alkfejl.cinema.controller;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.ActorDao;
import hu.elte.inf.alkfejl.cinema.dao.CinemaRoomDao;
import hu.elte.inf.alkfejl.cinema.exception.DataNotValidException;
import hu.elte.inf.alkfejl.cinema.exception.DuplicatedDataException;
import hu.elte.inf.alkfejl.cinema.exception.MissingDataException;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.CinemaRoom;
import hu.elte.inf.alkfejl.cinema.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@RestController
@RequestMapping("/api/actors")
public class ActorController implements ControllerInterface<Actor> {

    @Autowired
    private ActorService actorService;

    @Override
    @Role(ADMIN)
    @PostMapping("/update")
    public void update(@RequestBody Actor actor) {

        try {
            actorService.update(actor);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            actorService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Actor actor) {
        try {
            actorService.delete(actor);
        } catch (DataNotValidException e) {

        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Actor actor) {
        try {
            actorService.create(actor);
        } catch (DuplicatedDataException e) {

        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Actor get(@PathVariable Integer id) {
        return actorService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Actor> getAll() {
        return actorService.getAll();
    }
}
