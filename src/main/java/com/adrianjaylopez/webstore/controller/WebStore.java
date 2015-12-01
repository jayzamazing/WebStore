package com.adrianjaylopez.webstore.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class is basically going to act like the dispatcher servlet once everything is setup.
 *
 * @author Adrian J Lopez
 * @since <pre>6/14/15</pre>
 * @version 1.4
 */

@Controller
public class WebStore {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index2() {return "index";}

    @RequestMapping(value = "/main")
    public String main(@RequestHeader(value = "Authorization", required = false) String auth){
        if(auth != null && auth.compareTo("hs5533frehjlopop[]56") == 0)
            return "main";
        else
            return "index";
    }

    @PreAuthorize("hasRole('[ROLE_ADMIN]')")
    @RequestMapping(value = "/admin")
    public String admin(){ return "admin"; }



}