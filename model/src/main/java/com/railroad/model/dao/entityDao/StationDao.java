package com.railroad.model.dao.entityDao;

import com.railroad.model.dao.abstractDao.SessionDao;
import com.railroad.model.entity.Station;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 4/24/14.
 */
@Component("stationDao")
public class StationDao extends SessionDao<Station> {

    @Override
    public void save(Station object) { sessionFactory.getCurrentSession().save(object);}

    @Override
    public void update(Station object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Station object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Station get(Integer id) { return (Station) sessionFactory.getCurrentSession().load(Station.class, id); }

    @Override
    public List<Station> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Station").list();
    }
}
