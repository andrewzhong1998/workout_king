package com.iamvickyav.springbootmvcjsp.controllers;

import com.iamvickyav.springbootmvcjsp.models.User;
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
        return User.getUserByEmail(email);
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
