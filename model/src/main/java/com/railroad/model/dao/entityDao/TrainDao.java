package com.railroad.model.dao.entityDao;

import com.railroad.model.dao.abstractDao.SessionDao;
import com.railroad.model.entity.Train;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/8/2014.
 */
@Component("trainDao")
public class TrainDao extends SessionDao<Train> {

    @Override
    public void save(Train object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void update(Train object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(Train object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Train get(Integer id) {
        return (Train) sessionFactory.getCurrentSession().load(Train.class, id);
    }

    @Override
    public List<Train> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Train").list();
    }
}
