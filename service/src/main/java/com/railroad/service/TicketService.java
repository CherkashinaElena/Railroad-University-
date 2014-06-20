package com.railroad.service;

import com.railroad.model.entity.Ticket;
import com.railroad.model.entity.Typeofwagon;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Elena on 6/11/2014.
 */
@Transactional
@Service("ticketService")
public class TicketService extends IService<Ticket> {

    @Override
    public void save(Ticket object) {
        ticketDao.save(object);
    }

    @Override
    public void update(Ticket object) {
        ticketDao.update(object);
    }

    @Override
    public void delete(Ticket object) {
        ticketDao.delete(object);
    }

    @Override
    public Ticket get(Integer id) {
        return ticketDao.get(id);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    @Transactional
    public Double getPriceTicket(Double kilometers, Typeofwagon typeofwagon){
        return ticketRepository.getTicketPrice(kilometers, typeofwagon);
    }
}
