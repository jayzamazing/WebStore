package com.adrianjaylopez.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is basically going to act like the dispatcher servlet once everything is setup.
 *
 * @Author Adrian J Lopez
 * @since <pre>6/14/15</pre>
 * @version 1.0
 */

@Controller
public class WebStore {

    @RequestMapping(value = "/")
    public String index(Model model){
        return "index";
    }
}
