package com.adrianjaylopez.webstore.controller;

import com.adrianjaylopez.webstore.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * This class is going to deal with uploading the images that will be used for the items pictures.
 * @Author Adrian J Lopez
 * @since <pre>6/22/15</pre>
 * @version 1.1
 */
@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * This method deals with uploading pictures to be stored in file system
     * along with
     * @param name
     * @param item
     * @param file
     * @return
     */
    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String fileUpload(@RequestParam("name") String name, @RequestParam("itemNumber") String item,
                             @RequestParam("file") MultipartFile file){

        return uploadService.imageUpload(name, file);
    }
}
