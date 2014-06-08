package com.railroad.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/8/2014.
 */
@Repository("trainRepository")
public class TrainRepository extends IRepository{

    public List getTrainByNumberTrain(String numberTrain){
        return sessionFactory.getCurrentSession().createQuery("from Train where numbertrain = '" + numberTrain + "'").list();
    }
}
