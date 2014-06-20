package com.railroad.controller;

import com.railroad.model.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Elena on 6/11/2014.
 */
@Controller
public class SecureController {

    @ModelAttribute
    public User populateCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public ModelAndView secure() {
        return new ModelAndView("redirect:/admin");
    }
}
