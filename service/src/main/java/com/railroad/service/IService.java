package com.railroad.service;

import com.railroad.model.dao.abstractDao.Dao;
import com.railroad.model.entity.Station;
import com.railroad.model.entity.Train;
import com.railroad.model.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Elena on 4/24/14.
 */
@Service
public abstract class IService<T> {

    //dao
    @Autowired
    @Qualifier("stationDao")
    Dao<Station> stationDao;

    @Autowired
    @Qualifier("trainDao")
    Dao<Train> trainDao;

    //repository
    @Autowired
    @Qualifier("stationRepository")
    StationRepository stationRepository;

    public abstract void save(T object);

    public abstract void update(T object);

    public abstract void delete(T object);

    public abstract T get(Integer id);

    public abstract List<T> getAll();
}
