package com.iamvickyav.springbootmvcjsp.controllers;

import com.iamvickyav.springbootmvcjsp.models.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Object login(@RequestParam String email, @RequestParam String password, HttpServletResponse response){
        Cookie cookie = new Cookie("status", "login");
        cookie.setPath("/");
        response.addCookie(cookie);
        return User.getUserByEmail(email);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    Object logout(HttpServletResponse response){
        Cookie cookie = new Cookie("status", null);
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    Object signup(@RequestParam String email, @RequestParam String password){
        return User.createUser(email,password);
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.PUT)
    Object updateUserById(@PathVariable("uid") int uid,
                          @RequestParam String name,
                          @RequestParam double height,
                          @RequestParam double target_weight,
                          @RequestParam String gender){
        return User.updateUserById(uid,name,height,target_weight,gender);
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    Object getUserById(@PathVariable("uid") int uid){
        return User.getUserById(uid);
    }
}
