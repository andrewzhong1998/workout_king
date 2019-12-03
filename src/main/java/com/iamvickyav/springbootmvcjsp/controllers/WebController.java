package com.iamvickyav.springbootmvcjsp.controllers;

import com.iamvickyav.springbootmvcjsp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    /**
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    ModelAndView getIndexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    ModelAndView getLoginPage(@CookieValue(value = "email", defaultValue = "unknown") String email,
                              @CookieValue(value = "password", defaultValue = "unknown") String password){
        if(User.getUserByEmailAndPassword(email,password)==null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    ModelAndView getSignupPage(@CookieValue(value = "email", defaultValue = "unknown") String email,
                               @CookieValue(value = "password", defaultValue = "unknown") String password) {
        if(User.getUserByEmailAndPassword(email,password)==null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("signup");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_dashboard");
        return modelAndView;
    }

    @RequestMapping(value = {"/user/dashboard","/user/"},method = RequestMethod.GET)
    Object getUserDashboardPage(@CookieValue(value = "email", defaultValue = "unknown") String email,
                           @CookieValue(value = "password", defaultValue = "unknown") String password){
        if(User.getUserByEmailAndPassword(email,password)==null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/user/profile",method = RequestMethod.GET)
    Object getUserProfilePage(@CookieValue(value = "email", defaultValue = "unknown") String email,
                           @CookieValue(value = "password", defaultValue = "unknown") String password){
        if(User.getUserByEmailAndPassword(email,password)==null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_profile");
        return modelAndView;
    }

    @RequestMapping(value = "/user/setting",method = RequestMethod.GET)
    Object getUserSettingPage(@CookieValue(value = "email", defaultValue = "unknown") String email,
                              @CookieValue(value = "password", defaultValue = "unknown") String password){
        if(User.getUserByEmailAndPassword(email,password)==null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_setting");
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
    **/
}
