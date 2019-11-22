package com.iamvickyav.springbootmvcjsp.controllers;

import com.iamvickyav.springbootmvcjsp.connection.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;

@Controller
public class WebController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String getHomePage(){
        Connection conn = Database.getConnection();
        return "home";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    ModelAndView getProfilePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        modelAndView.addObject("title","Mr");
        modelAndView.addObject("name","Dhoni");
        return modelAndView;
    }
}
