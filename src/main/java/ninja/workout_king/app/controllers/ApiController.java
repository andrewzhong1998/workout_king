package ninja.workout_king.app.controllers;

import ninja.workout_king.app.models.Diet;
import ninja.workout_king.app.models.Intake;
import ninja.workout_king.app.models.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
    Object signup(@RequestParam String email,
                  @RequestParam String password,
                  @RequestParam String name,
                  @RequestParam double height,
                  @RequestParam double target_weight,
                  @RequestParam String gender,
                  @RequestParam String motto,
                  HttpServletResponse response){
        Cookie cookie1 = new Cookie("email", email);
        Cookie cookie2 = new Cookie("password", password);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return User.createUser(email,password,name,height,target_weight,gender,motto);
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

    @RequestMapping(value = "/user/intake_json", method = RequestMethod.POST)
    Object insertIntakeJSON(@CookieValue(value="email", defaultValue="unknown") String email,
                        @CookieValue(value="password", defaultValue="unknown") String password,
                        @RequestBody Map<String,Object> json
    ){
        int uid = User.userExist(email, password);
        if(uid==-1) return false;
        return Intake.insertIntakeJSON(uid,email,json);
    }

    @RequestMapping(value = "/user/intake/{date}", method = RequestMethod.GET)
    Object getUserIntakeByDate(@CookieValue(value="email", defaultValue="unknown") String email,
                            @CookieValue(value="password", defaultValue="unknown") String password,
                            @PathVariable String date
    ){
        int uid = User.userExist(email, password);
        if(uid==-1) return false;
        return Intake.getUserIntakesByDate(uid,date);
    }

    @RequestMapping(value = "/user/intake/summary", method = RequestMethod.GET)
    Object getUserIntakeSummary(@CookieValue(value="email", defaultValue="unknown") String email,
                               @CookieValue(value="password", defaultValue="unknown") String password
    ){
        int uid = User.userExist(email, password);
        if(uid==-1) return false;
        return Intake.getUserIntakesSummary(uid);
    }

}
