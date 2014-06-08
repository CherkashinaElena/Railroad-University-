package com.railroad.model.dao.entityDao;

import com.railroad.model.dao.abstractDao.SessionDao;
import com.railroad.model.entity.Route;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/8/2014.
 */
@Component("routeDao")
public class RouteDao extends SessionDao<Route>{

    @Override
    public void save(Route object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Route object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(Route object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Route get(Integer id) {
        return (Route) sessionFactory.getCurrentSession().load(Route.class, id);
    }

    @Override
    public List<Route> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Route").list();
    }
}
