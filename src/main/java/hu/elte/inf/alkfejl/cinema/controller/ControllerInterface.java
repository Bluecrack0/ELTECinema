package hu.elte.inf.alkfejl.cinema.controller;


import hu.elte.inf.alkfejl.cinema.model.ModelInterface;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

public interface ControllerInterface<Entity extends ModelInterface> {


    void update(Entity entity);
    void delete(Entity entity);
    void create(Entity entity);
    void deleteById(Integer id);
    Entity get(Integer id);
    List<Entity> getAll();
}
