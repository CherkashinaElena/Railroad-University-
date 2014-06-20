package com.railroad.model.repository;

import com.railroad.model.entity.Route;
import com.railroad.model.entity.Station;
import com.railroad.model.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Elena on 6/8/2014.
 */
@Repository("trainRepository")
public class TrainRepository extends IRepository{

    @Autowired
    @Qualifier("stationRepository")
    StationRepository stationRepository;

    public List getTrainByNumberTrain(String numberTrain){
        return sessionFactory.getCurrentSession().createQuery("from Train where numbertrain = '" + numberTrain + "'").list();
    }

    public List searchTrains(String nameStationFrom, String nameStationTo){

        return sessionFactory.getCurrentSession().createQuery("select distinct route1.trainByIdtrain from Route as route1, Route as route2 " +
                "where route1.stationByIdstation.namestation = '" + nameStationFrom + "' and " +
                "route2.stationByIdstation.namestation = '" + nameStationTo + "' and " +
                "route1.priority < route2.priority)").list();
    }
}
