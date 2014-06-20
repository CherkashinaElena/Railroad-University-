package com.railroad.model.repository;

import com.railroad.model.entity.Route;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

/**
 * Created by Elena on 6/11/2014.
 */
@Repository("routeRepository")
public class RouteRepository extends IRepository{

    public Route getRouteByTrainandStation(int idTrain, String nameStation){

        List<Route> routes = sessionFactory.getCurrentSession().createQuery("from Route " +
                "where idtrain = " + idTrain + " and stationByIdstation.namestation = '" + nameStation + "'").list();

        Route route = new Route();

        for(Route r : routes){
            route = r;
        }

        return route;
    }

    public Double getKilometers(Route routeOut, Route routeIn){
        return routeIn.getKilometers() - routeOut.getKilometers();
    }
}
