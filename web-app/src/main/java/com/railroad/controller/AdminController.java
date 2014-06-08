package com.railroad.controller;

import com.railroad.model.entity.Route;
import com.railroad.model.entity.Station;
import com.railroad.model.entity.Train;
import com.railroad.service.StationService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Elena on 4/28/2014.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends AbstractController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminPage(){
        return new ModelAndView("redirect:/admin/stations");
    }

    //Stations

    @RequestMapping(value = "/stations", method = RequestMethod.GET)
     public ModelAndView adminStationsPage(){

        ModelAndView modelAndView = new ModelAndView("admin_station_page", "stationsList", stationService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/stations/addStation", method = RequestMethod.GET)
    public ModelAndView addStationPage(){

        return new ModelAndView("admin_add_station", "commandAddStation", new Station());
    }

    @RequestMapping(value="/stations/saveStation", method = RequestMethod.POST)
    public ModelAndView addingStation(@ModelAttribute Station station) {

        stationService.save(station);

        return new ModelAndView("redirect:/admin/stations");
    }

    //Trains
    @RequestMapping(value = "/trains", method = RequestMethod.GET)
    public ModelAndView adminTrainsPage(){

        ModelAndView modelAndView = new ModelAndView("admin_trains_page", "trainList", trainService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/trains/addTrain", method = RequestMethod.GET)
    public ModelAndView addTrainPage(){

        return new ModelAndView("admin_add_train", "commandAddTrain", new Train());
    }

    @RequestMapping(value="/trains/saveTrain", method = RequestMethod.POST)
    public ModelAndView addingTrain(@ModelAttribute Train train) {

        trainService.save(train);

        return new ModelAndView("redirect:/admin/trains");
    }
}
