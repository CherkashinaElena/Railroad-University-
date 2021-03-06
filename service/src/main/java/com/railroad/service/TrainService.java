package com.railroad.service;

import com.railroad.model.entity.Route;
import com.railroad.model.entity.Station;
import com.railroad.model.entity.Train;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Elena on 6/8/2014.
 */
@Transactional
@Service("trainService")
public class TrainService extends IService<Train>{

    @Override
    public void save(Train object) {
        trainDao.save(object);
    }

    @Override
    public void update(Train object) {
        trainDao.update(object);
    }

    @Override
    public void delete(Train object) {
        trainDao.delete(object);
    }

    @Override
    public Train get(Integer id) {
        return trainDao.get(id);
    }

    @Override
    public List<Train> getAll() {
        return trainDao.getAll();
    }

    @Transactional
    public Train getTrainByNumberTrain(String numberTrain) {
        List<Train> trains = trainRepository.getTrainByNumberTrain(numberTrain);

        Train train = new Train();

        for (Train t : trains) {
            train = t;
        }
        return train;
    }

    @Transactional
    public List searchTrains(String stationFrom, String stationTo){
        return trainRepository.searchTrains(stationFrom, stationTo);
    }
}
