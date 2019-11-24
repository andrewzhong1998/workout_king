package com.iamvickyav.springbootmvcjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    ModelAndView getIndexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    ModelAndView getLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    ModelAndView getSignupPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    ModelAndView getProfilePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        modelAndView.addObject("title","Mr");
        modelAndView.addObject("name","Dhoni");
        return modelAndView;
    }

    @RequestMapping(value = "/user_info",method = RequestMethod.GET)
    Object getUserInfoPage(@CookieValue(value = "status", defaultValue = "unknown") String status){
        if(!status.equals("login")){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_info");
        return modelAndView;
    }
}
