package com.railroad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Elena on 6/12/2014.
 */
@Controller
public class LogoutController {
    @RequestMapping(value = "/logout/user", method = RequestMethod.GET)
    public ModelAndView secure() {
        return new ModelAndView("redirect:/");
    }
}
