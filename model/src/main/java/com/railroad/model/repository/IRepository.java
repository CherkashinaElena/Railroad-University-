package com.railroad.model.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;

/**
 * Created by Elena on 6/7/2014.
 */
@Transactional(Transactional.TxType.REQUIRED)
public abstract class IRepository {

    @Autowired
    @Qualifier("sessionFactory")
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
