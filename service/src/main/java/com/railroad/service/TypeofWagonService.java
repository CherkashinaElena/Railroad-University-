package com.railroad.service;

import com.railroad.model.entity.Typeofwagon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Elena on 6/9/2014.
 */
@Transactional
@Service("typeofwagonService")
public class TypeofWagonService extends IService<Typeofwagon>{
    @Override
    public void save(Typeofwagon object) {
        typeofwagonDao.save(object);
    }

    @Override
    public void update(Typeofwagon object) {
        typeofwagonDao.update(object);
    }

    @Override
    public void delete(Typeofwagon object) {
        typeofwagonDao.delete(object);
    }

    @Override
    public Typeofwagon get(Integer id) {
        return typeofwagonDao.get(id);
    }

    @Override
    public List<Typeofwagon> getAll() {
        return typeofwagonDao.getAll();
    }

    public Typeofwagon getTypeofWagon(String type, String clazz){

        List<Typeofwagon> typeofwagons = typeofWagonRepository.getIdTypeofwagon(type, clazz);

        Typeofwagon typeofwagon = new Typeofwagon();

        for (Typeofwagon t : typeofwagons) {
            typeofwagon = t;
        }
        return typeofwagon;
    }
}
