package com.railroad.model.dao.entityDao;

import com.railroad.model.dao.abstractDao.SessionDao;
import com.railroad.model.entity.Typeofwagon;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/9/2014.
 */
@Component("typeofwagonDao")
public class TypeofwagonDao extends SessionDao<Typeofwagon>{

    @Override
    public void save(Typeofwagon object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Typeofwagon object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(Typeofwagon object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Typeofwagon get(Integer id) {
        return (Typeofwagon) sessionFactory.getCurrentSession().load(Typeofwagon.class, id);
    }

    @Override
    public List<Typeofwagon> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Typeofwagon").list();
    }
}
