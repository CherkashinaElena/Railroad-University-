package com.railroad.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/7/2014.
 */
@Repository("stationRepository")
public class StationRepository extends IRepository{

    public List getStationByName(String nameStation){
        return sessionFactory.getCurrentSession().createQuery("from Station  where namestation = '" + nameStation + "'").list();
    }
}
