package com.railroad.controller;

import com.railroad.model.entity.*;
import com.railroad.service.PlaceService;
import com.railroad.service.RouteService;
import com.railroad.service.TicketService;
import com.railroad.service.TrainService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Elena on 6/9/2014.
 */
@Controller
@RequestMapping(value = "/")
public class VisitorController extends AbstractController {

    private Ticket clientTicket = new Ticket();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mainPage() {

        return new ModelAndView("visitor_main_page");
    }

    @RequestMapping(value = "/searchtrain", method = RequestMethod.GET)
    public ModelAndView searchTrainPage() {

        return new ModelAndView("visitor_search_train_page", "commandSearchTrain", new Ticket());
    }

    @RequestMapping(value = "/searchtrain/search", method = RequestMethod.POST)
    public ModelAndView searchTrainResultPage(@ModelAttribute Ticket ticket) throws ParseException {

        clientTicket = ticket;

        String routefrom = ticket.getRouteByIdrouteout().getStationByIdstation().getNamestation();
        String routeto = ticket.getRouteByIdroutein().getStationByIdstation().getNamestation();

        List<Train> trainList = ((TrainService)trainService).searchTrains(routefrom, routeto);

        return new ModelAndView("visitor_search_result", "trainList", trainList);
    }

    @RequestMapping("/selectTrain/{idtrain}")
    public ModelAndView selectTrain(@PathVariable("idtrain")int idTrain) throws ParseException {

        Train train = trainService.get(idTrain);

        clientTicket.setIdtrain(idTrain);

        Route routeOut = ((RouteService)routeService).getRoutebyTrainandStation(train.getIdtrain(), clientTicket.getRouteByIdrouteout().getStationByIdstation().getNamestation());
        Route routeIn = ((RouteService)routeService).getRoutebyTrainandStation(train.getIdtrain(), clientTicket.getRouteByIdroutein().getStationByIdstation().getNamestation());

        clientTicket.setIdrouteout(routeOut.getIdroute());
        clientTicket.setIdroutein(routeIn.getIdroute());

        clientTicket.setRouteByIdrouteout(routeOut);
        clientTicket.setRouteByIdroutein(routeIn);

        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(clientTicket.getDatein());

        List<Place> places = ((PlaceService)placeService).getFreePlaces(train, dateString);

        return new ModelAndView("visitor_free_train_places", "placeList", places);
    }

    @RequestMapping("/selectPlace/{idplace}")
    public ModelAndView selectPlace(@PathVariable("idplace")int idPlace) throws ParseException {

        Place place = placeService.get(idPlace);

        clientTicket.setIdplace(idPlace);
        clientTicket.setPlaceByIdplace(place);

        Double kilometers = ((RouteService)routeService).getKilometers(clientTicket.getRouteByIdrouteout(), clientTicket.getRouteByIdroutein());

        Double price = ((TicketService)ticketService).getPriceTicket(kilometers, clientTicket.getPlaceByIdplace().getWagon().getTypeofwagonByIdtypeofwagon());

        clientTicket.setPrice(price);

        ModelAndView modelAndView = new ModelAndView("visitor_ticket_order", "commandCreateOrder", clientTicket);

        modelAndView.addObject("date", new SimpleDateFormat("dd/MM/yyyy").format(clientTicket.getDatein()));

        return modelAndView;
    }

    @RequestMapping(value="/makeOrder", method = RequestMethod.POST)
    public ModelAndView addingStation(@ModelAttribute Ticket ticket) {

        ModelAndView modelAndView = new ModelAndView("visitor_print_ticket", "ticket", clientTicket);

        clientTicket.setNameclient(ticket.getNameclient());
        clientTicket.setSurnameclient(ticket.getSurnameclient());
        clientTicket.setGender(ticket.getGender());
        clientTicket.setDocument(ticket.getDocument());

        ticketService.save(clientTicket);

        String dateOut = new SimpleDateFormat("dd/MM/yyyy").format(clientTicket.getDatein());
        String timeOut = new SimpleDateFormat("HH:mm").format(clientTicket.getRouteByIdrouteout().getTimeout());
        String timeIn = new SimpleDateFormat("HH:mm").format(clientTicket.getRouteByIdroutein().getTimein());

        modelAndView.addObject("dateOut", dateOut);
        modelAndView.addObject("timeOut", timeOut);
        modelAndView.addObject("timeIn", timeIn);

        return modelAndView;
    }
}
