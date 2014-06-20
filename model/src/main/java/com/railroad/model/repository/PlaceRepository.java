package com.railroad.model.repository;

import com.railroad.model.entity.Place;
import com.railroad.model.entity.Train;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/10/2014.
 */
@Repository("placeRepository")
public class PlaceRepository extends IRepository{

    public List getFreePlaces(Train train, String date){

        return sessionFactory.getCurrentSession().createQuery("select place from Place as place " +
                "where not exists(select ticket.idplace " +
                "from Ticket as ticket " +
                "where ticket.idplace = place.idplace and " +
                "ticket.datein = to_date('" + date + "', 'yyyy-MM-dd')) and  place.wagon.trainByIdtrain.numbertrain = '" + train.getNumbertrain() + "'" +
                " order by place.idwagon, placeno").list();
    }
}
