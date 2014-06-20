package com.railroad.model.repository;

import com.railroad.model.entity.Wagon;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/15/2014.
 */
@Repository("wagonRepository")
public class WagonRepository extends IRepository{

    public Wagon getWagon(int idWagon, String numberTrain){

        List<Wagon> wagonList = sessionFactory.getCurrentSession().createQuery("from Wagon " +
                "where idwagon = " + idWagon + " and trainByIdtrain.numbertrain = '" + numberTrain + "'").list();

        Wagon wagon = new Wagon();

        for(Wagon w : wagonList){
            wagon = w;
        }
        return wagon;
    }
}
