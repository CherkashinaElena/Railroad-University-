package com.railroad.controller;

import com.railroad.model.entity.*;
import com.railroad.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Elena on 5/10/2014.
 */
public abstract class AbstractController {

    @Autowired
    @Qualifier("stationService")
    IService<Station> stationService;

    @Autowired
    @Qualifier("trainService")
    IService<Train> trainService;

    @Autowired
    @Qualifier("routeService")
    IService<Route> routeService;

    @Autowired
    @Qualifier("typeofwagonService")
    IService<Typeofwagon> typeofwagonService;

    @Autowired
    @Qualifier("wagonService")
    IService<Wagon> wagonService;

    @Autowired
    @Qualifier("placeService")
    IService<Place> placeService;

    @Autowired
    @Qualifier("ticketService")
    IService<Ticket> ticketService;
}
