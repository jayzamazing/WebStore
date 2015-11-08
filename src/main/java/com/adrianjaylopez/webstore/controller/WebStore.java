package com.adrianjaylopez.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * This class is basically going to act like the dispatcher servlet once everything is setup.
 *
 * @author Adrian J Lopez
 * @since <pre>6/14/15</pre>
 * @version 1.1
 */

@Controller
public class WebStore {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public @ResponseBody userType admin(HttpServletResponse response) {
        return new userType("admin");
    }

}

/**
 * Test object for front end authentication, going to replace with spring security later on.
 */
class userType{
    String userType;
    boolean authenticated = false;
    userType(String userType){
       this.userType = userType;
        authenticated = true;
    }

    public String getUserType(){return userType;}
    public boolean getAuthenticated(){return authenticated;}
}
