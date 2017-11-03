package hu.elte.inf.alkfejl.cinema.service;

import hu.elte.inf.alkfejl.cinema.model.Reservation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class ReservationService extends AbstractService<Reservation> {

}
