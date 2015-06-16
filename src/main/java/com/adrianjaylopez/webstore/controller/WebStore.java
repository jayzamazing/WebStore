package com.adrianjaylopez.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Adrian J Lopez
 */

@Controller
public class WebStore {

    @RequestMapping(value = "/")
    public String index(Model model){
        return "index";
    }
}
