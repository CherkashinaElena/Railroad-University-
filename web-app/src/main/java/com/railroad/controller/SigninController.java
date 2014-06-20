package com.railroad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Elena on 6/11/2014.
 */
@Controller
public class SigninController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        return new ModelAndView();
    }

    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public ModelAndView signinFailure() {
        return new ModelAndView("signin_failure");
    }
}
