package com.railroad.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.railroad.model.entity.Route;
import com.railroad.model.entity.Station;
import com.railroad.model.entity.Train;
import com.railroad.service.StationService;
import com.railroad.service.TrainService;
import org.json.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.json.Json;
import javax.json.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @RequestMapping(value = "/stations/addStation/checkStation", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxStations(WebRequest request) throws Exception {

        String available = "";

        String nameStation = request.getParameter("namestation");

        Station checkStation = new Station();
        Station station = ((StationService)stationService).getStationByNameStation(nameStation);

        if(station.equals(checkStation)){
            available = "true";
        }else{
            available = "false";
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(available);
    }

    @RequestMapping(value = "/trains/addTrain/checkTrain", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxTrains(WebRequest request) throws Exception {

        String available = "";

        String numbertrain = request.getParameter("numbertrain");

        Train checkTrain = new Train();
        Train train = ((TrainService)trainService).getTrainByNumberTrain(numbertrain);

        if(train.equals(checkTrain)){
            available = "true";
        }else{
            available = "false";
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(available);
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

    //Routes
    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ModelAndView adminRoutesPage(){

        ModelAndView modelAndView = new ModelAndView("admin_routes_page", "routeList", routeService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/routes/addRoute", method = RequestMethod.GET)
    public ModelAndView addRoutePage(){

        ModelAndView modelAndView = new ModelAndView("admin_add_route", "commandAddRoute", new Route());

        modelAndView.addObject("stationsOptionsList", stationService.getAll());
        modelAndView.addObject("trainsOptionsList", trainService.getAll());

        return modelAndView;
    }

    @RequestMapping(value="/routes/saveRoute", method = RequestMethod.POST)
    public ModelAndView addingRoute(@ModelAttribute Route route) {

        Station station = ((StationService)stationService).getStationByNameStation(route.getStationByIdstation().getNamestation());
        Train train = ((TrainService)trainService).getTrainByNumberTrain(route.getTrainByIdtrain().getNumbertrain());

        route.setIdstation(station.getIdstation());
        route.setIdtrain(train.getIdtrain());

        route.setStationByIdstation(station);
        route.setTrainByIdtrain(train);

        routeService.save(route);

        return new ModelAndView("redirect:/admin/routes");
    }
}
