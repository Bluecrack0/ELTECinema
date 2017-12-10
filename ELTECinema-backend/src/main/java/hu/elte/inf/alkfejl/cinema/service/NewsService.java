package hu.elte.inf.alkfejl.cinema.service;

import hu.elte.inf.alkfejl.cinema.dao.NewsDao;
import hu.elte.inf.alkfejl.cinema.dao.UserDao;
import hu.elte.inf.alkfejl.cinema.model.News;
import hu.elte.inf.alkfejl.cinema.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class NewsService extends AbstractService<News> {

    @Autowired
    private NewsDao newsDao;
}
