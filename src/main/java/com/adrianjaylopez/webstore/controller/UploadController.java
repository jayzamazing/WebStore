package com.adrianjaylopez.webstore.controller;

import com.adrianjaylopez.webstore.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is going to deal with uploading the images that will be used for the items pictures.
 * @author Adrian J Lopez
 * @since <pre>6/22/15</pre>
 * @version 1.2
 */
@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public ResponseEntity fileUpload(){

        return null;//TODO complete when fully implemented
    }
}
