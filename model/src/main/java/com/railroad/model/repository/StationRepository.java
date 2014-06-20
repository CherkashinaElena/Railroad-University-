package com.railroad.model.repository;

import com.railroad.model.entity.Station;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/7/2014.
 */
@Repository("stationRepository")
public class StationRepository extends IRepository{

    public Station getStationByName(String nameStation){

        List<Station> stations = sessionFactory.getCurrentSession().createQuery("from Station  where namestation = '" + nameStation + "'").list();

        Station station = new Station();

        for (Station s : stations) {
            station = s;
        }
        return station;
    }
}
