package com.railroad.service;

import com.railroad.model.dao.abstractDao.Dao;
import com.railroad.model.entity.*;
import com.railroad.model.repository.*;
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

    @Autowired
    @Qualifier("routeDao")
    Dao<Route> routeDao;

    @Autowired
    @Qualifier("typeofwagonDao")
    Dao<Typeofwagon> typeofwagonDao;

    @Autowired
    @Qualifier("wagonDao")
    Dao<Wagon> wagonDao;

    @Autowired
    @Qualifier("placeDao")
    Dao<Place> placeDao;

    @Autowired
    @Qualifier("ticketDao")
    Dao<Ticket> ticketDao;

    //repository
    @Autowired
    @Qualifier("stationRepository")
    StationRepository stationRepository;

    @Autowired
    @Qualifier("trainRepository")
    TrainRepository trainRepository;

    @Autowired
    @Qualifier("typeofwagonRepository")
    TypeofWagonRepository typeofWagonRepository;

    @Autowired
    @Qualifier("wagonRepository")
    WagonRepository wagonRepository;

    @Autowired
    @Qualifier("placeRepository")
    PlaceRepository placeRepository;

    @Autowired
    @Qualifier("routeRepository")
    RouteRepository routeRepository;

    @Autowired
    @Qualifier("ticketRepository")
    TicketRepository ticketRepository;

    public abstract void save(T object);

    public abstract void update(T object);

    public abstract void delete(T object);

    public abstract T get(Integer id);

    public abstract List<T> getAll();
}
