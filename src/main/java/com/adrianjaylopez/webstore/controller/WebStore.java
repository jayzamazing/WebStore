package com.adrianjaylopez.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
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

    @RequestMapping(value = "/userInfo")
    public String admin(HttpServletResponse response) {
        UserCredentials userType = new UserCredentials();
        String type = userType.userType("admin", "admin");
        Cookie foo = new Cookie("UserType", type);
        foo.setMaxAge(1800);
        response.addCookie(foo);
        if (type == "admin")
            return "admin";
        else
            return "blah";
    }

}
