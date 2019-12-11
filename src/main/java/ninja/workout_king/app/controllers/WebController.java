package ninja.workout_king.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    String logout(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("email", null);
        Cookie cookie2 = new Cookie("password", null);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "You have successfully logged out.";
    }
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
