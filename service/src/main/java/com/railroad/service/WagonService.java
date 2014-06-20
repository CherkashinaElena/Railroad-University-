package com.railroad.service;

import com.railroad.model.entity.Train;
import com.railroad.model.entity.Wagon;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Elena on 6/9/2014.
 */
@Transactional
@Service("wagonService")
public class WagonService extends IService<Wagon> {

    @Override
    public void save(Wagon object) {
        wagonDao.save(object);
    }

    @Override
    public void update(Wagon object) {
        wagonDao.update(object);
    }

    @Override
    public void delete(Wagon object) {
        wagonDao.delete(object);
    }

    @Override
    public Wagon get(Integer id) {
        return null;
    }

    @Override
    public List<Wagon> getAll() {
        return wagonDao.getAll();
    }

    @Transactional
    public Wagon getWagon(int idWagon, String numberTrain){
        return wagonRepository.getWagon(idWagon, numberTrain);
    }
}
