package com.railroad.service;

import com.railroad.model.entity.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Elena on 4/24/14.
 */
@Service("stationService")
@Transactional
public class StationService extends IService<Station> {

    @Override
    public void save(Station object) {
        stationDao.save(object);
    }

    @Override
    public void update(Station object) {
        stationDao.update(object);
    }

    @Override
    public void delete(Station object) {
        stationDao.delete(object);
    }

    @Override
    public Station get(Integer id) {
        return stationDao.get(id);
    }

    @Override
    public List<Station> getAll() {
        return stationDao.getAll();
    }

    @Transactional
    public Station getStationByNameStation(String nameStation) {
        List<Station> stations = stationRepository.getStationByName(nameStation);

        Station station = new Station();

        for (Station s : stations) {
            station = s;
        }
        return station;
    }
}
