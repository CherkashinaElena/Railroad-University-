package com.railroad.controller;

import com.railroad.model.entity.Station;
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
}
