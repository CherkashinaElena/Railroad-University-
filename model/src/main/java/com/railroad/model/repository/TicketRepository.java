package com.railroad.model.repository;

import com.railroad.model.entity.Typeofwagon;
import org.springframework.stereotype.Repository;

/**
 * Created by Elena on 6/11/2014.
 */
@Repository("ticketRepository")
public class TicketRepository extends IRepository{

    private final Double tax = 0.45;

    public Double getTicketPrice(Double kilometers, Typeofwagon typeofWagon){
        return kilometers * tax + typeofWagon.getPrice();
    }
}
