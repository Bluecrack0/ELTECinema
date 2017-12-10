package hu.elte.inf.alkfejl.cinema.controller;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.model.News;
import hu.elte.inf.alkfejl.cinema.model.User;
import hu.elte.inf.alkfejl.cinema.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.GUEST;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@RestController
@RequestMapping("/api/news")
public class NewsController implements ControllerInterface<News> {

    @Autowired
    NewsService newsService;

    @Override
    public void update(News news) {

    }

    @Override
    public void delete(News news) {

    }

    @Override
    public void create(News news) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public News get(Integer id) {
        return newsService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getAll")
    @Override
    public List<News> getAll() {
        return newsService.getAll();
    }
}
