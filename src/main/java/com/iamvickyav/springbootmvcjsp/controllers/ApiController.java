package com.iamvickyav.springbootmvcjsp.controllers;

import com.iamvickyav.springbootmvcjsp.models.Diet;
import com.iamvickyav.springbootmvcjsp.models.Intake;
import com.iamvickyav.springbootmvcjsp.models.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Object login(@RequestParam String email, @RequestParam String password, HttpServletResponse response){
        Cookie cookie1 = new Cookie("email", email);
        Cookie cookie2 = new Cookie("password", password);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return User.getUserByEmailAndPassword(email,password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    Object logout(HttpServletResponse response){
        Cookie cookie1 = new Cookie("email", null);
        Cookie cookie2 = new Cookie("password", null);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return true;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    Object signup(@RequestParam String email, @RequestParam String password){
        return User.createUser(email,password);
    }

    @RequestMapping(value = "/user/me", method = RequestMethod.PUT)
    Object updateUserById(@CookieValue(value="email", defaultValue="unknown") String email,
                          @CookieValue(value="password", defaultValue="unknown") String password,
                          @RequestParam String name,
                          @RequestParam double height,
                          @RequestParam double target_weight,
                          @RequestParam String gender,
                          @RequestParam String motto){
        return User.updateUserByEmailAndPassword(email,password,name,height,target_weight,gender,motto);
    }

    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    Object getMyInfo(@CookieValue(value="email", defaultValue="unknown") String email,
                     @CookieValue(value="password", defaultValue="unknown") String password){
        return User.getUserByEmailAndPassword(email,password);
    }

    @RequestMapping(value = "/user/intake", method = RequestMethod.POST)
    Object insertIntake(@CookieValue(value="email", defaultValue="unknown") String email,
                        @CookieValue(value="password", defaultValue="unknown") String password,
                        @RequestParam double fat,
                        @RequestParam double protein,
                        @RequestParam double calories,
                        @RequestParam double carbohydrate,
                        @RequestParam String description,
                        @RequestBody List<Diet> diets
                        ){
        int uid = User.userExist(email,password);
        if(uid==-1) return false;
        return Intake.insertIntake(uid,fat,carbohydrate,protein,calories,description,diets);
    }

}
