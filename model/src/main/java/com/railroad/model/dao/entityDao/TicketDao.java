package com.railroad.model.dao.entityDao;

import com.railroad.model.dao.abstractDao.SessionDao;
import com.railroad.model.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/11/2014.
 */
@Component("ticketDao")
public class TicketDao extends SessionDao<Ticket> {

    @Override
    public void save(Ticket object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Ticket object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(Ticket object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Ticket get(Integer id) {
        return (Ticket) sessionFactory.getCurrentSession().load(Ticket.class, id);
    }

    @Override
    public List<Ticket> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Ticket").list();
    }
}
