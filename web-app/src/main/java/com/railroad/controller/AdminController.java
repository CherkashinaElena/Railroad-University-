package com.railroad.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Elena on 4/28/2014.
 */
@Controller
public class AdminController extends AbstractController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        return new ModelAndView("redirect:/admin/stations");
    }

    @RequestMapping(value = "/admin/stations", method = RequestMethod.GET)
     public ModelAndView adminStationsPage(){

        ModelAndView modelAndView = new ModelAndView("admin_station_page", "stationsList", stationService.getAll());
        return modelAndView;
    }
}
