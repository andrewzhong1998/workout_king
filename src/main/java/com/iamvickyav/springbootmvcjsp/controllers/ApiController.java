package com.iamvickyav.springbootmvcjsp.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    Object test(){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("status",true);
        return res;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Object login(@RequestParam String email, @RequestParam String password, @RequestParam boolean remember){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("status",true);
        res.put("email",email);
        res.put("password",password);
        res.put("remember",remember);
        return res;
    }
}
