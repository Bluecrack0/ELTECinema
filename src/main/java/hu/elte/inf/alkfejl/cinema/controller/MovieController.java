package hu.elte.inf.alkfejl.cinema.controller;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.DaoInterface;
import hu.elte.inf.alkfejl.cinema.dao.MovieDao;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import hu.elte.inf.alkfejl.cinema.model.Movie;
import hu.elte.inf.alkfejl.cinema.model.Screening;
import hu.elte.inf.alkfejl.cinema.service.ActorService;
import hu.elte.inf.alkfejl.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@RestController
@RequestMapping("/api/movies")
public class MovieController implements ControllerInterface<Movie>{

    @Autowired
    private MovieService movieService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Movie movie) {
        movieService.update(movie);
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        movieService.deleteById(id);
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Movie movie) {
        movieService.delete(movie);
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Movie movie) {
        movieService.create(movie);
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Movie get(@PathVariable Integer id) {
        return movieService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @Role({ADMIN, USER})
    @GetMapping("/getByActor/{actorId}")
    public List<Movie> getByActor(@PathVariable Integer actorId) {
        return movieService.getMoviesByActor(actorId);
    }

    @Role({ADMIN})
    @PostMapping("/addActorToMovie/{movieId}")
    public void addActorToMovie(@PathVariable Integer movieId, @RequestBody Actor actor) {
        movieService.addActorToMovie(movieId, actor.getId());
    }
}
