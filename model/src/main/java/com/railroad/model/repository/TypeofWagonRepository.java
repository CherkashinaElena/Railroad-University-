package com.railroad.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/9/2014.
 */
@Repository("typeofwagonRepository")
public class TypeofWagonRepository extends IRepository {

    public List getIdTypeofwagon(String type, String clazzCheck){
        return sessionFactory.getCurrentSession().createQuery(
                "from Typeofwagon where type = '" + type + "' and myclass = '" + clazzCheck + "'").list();
    }
}
