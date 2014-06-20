package com.railroad.service;

import com.railroad.model.entity.Route;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Elena on 6/8/2014.
 */
@Transactional
@Service("routeService")
public class RouteService extends IService {
    @Override
    public void save(Object object) {
        routeDao.save(object);
    }

    @Override
    public void update(Object object) {
        routeDao.update(object);
    }

    @Override
    public void delete(Object object) {
        routeDao.delete(object);
    }

    @Override
    public Object get(Integer id) {
        return routeDao.get(id);
    }

    @Override
    public List getAll() {
        return routeDao.getAll();
    }

    @Transactional
    public Route getRoutebyTrainandStation(int idTrain, String nameStation){
        return routeRepository.getRouteByTrainandStation(idTrain, nameStation);
    }

    @Transactional
    public Double getKilometers(Route routeOut, Route routeIn){
        return routeRepository.getKilometers(routeOut, routeIn);
    }
}
