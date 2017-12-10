package hu.elte.inf.alkfejl.cinema.service;

import hu.elte.inf.alkfejl.cinema.annotation.Role;
import hu.elte.inf.alkfejl.cinema.dao.ActorDao;
import hu.elte.inf.alkfejl.cinema.exception.DataNotValidException;
import hu.elte.inf.alkfejl.cinema.exception.DuplicatedDataException;
import hu.elte.inf.alkfejl.cinema.exception.MissingDataException;
import hu.elte.inf.alkfejl.cinema.model.Actor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

import static hu.elte.inf.alkfejl.cinema.model.User.Role.ADMIN;
import static hu.elte.inf.alkfejl.cinema.model.User.Role.USER;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class ActorService extends AbstractService<Actor> {
}
