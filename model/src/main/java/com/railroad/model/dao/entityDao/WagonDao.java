package com.railroad.model.dao.entityDao;

import com.railroad.model.dao.abstractDao.SessionDao;
import com.railroad.model.entity.Wagon;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/9/2014.
 */
@Component("wagonDao")
public class WagonDao extends SessionDao<Wagon> {
    @Override
    public void save(Wagon object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Wagon object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(Wagon object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Wagon get(Integer id) {
        return null;
    }

    @Override
    public List<Wagon> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Wagon order by trainByIdtrain.numbertrain, idwagon").list();
    }
}
