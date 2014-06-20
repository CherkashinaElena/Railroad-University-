package com.railroad.service;

import com.railroad.model.entity.Place;
import com.railroad.model.entity.Train;
import com.railroad.model.entity.Wagon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Elena on 6/10/2014.
 */
@Transactional
@Service("placeService")
public class PlaceService extends IService<Place>{

    @Override
    public void save(Place object) {
        placeDao.save(object);
    }

    @Override
    public void update(Place object) {
        placeDao.update(object);
    }

    @Override
    public void delete(Place object) {
        placeDao.delete(object);
    }

    @Override
    public Place get(Integer id) {
        return placeDao.get(id);
    }

    @Override
    public List<Place> getAll() {
        return placeDao.getAll();
    }

    @Transactional
    public List getFreePlaces(Train train, String date){
        return placeRepository.getFreePlaces(train, date);
    }
}
