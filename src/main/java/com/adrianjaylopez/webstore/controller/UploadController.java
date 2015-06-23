package com.adrianjaylopez.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * This class is going to deal with uploading the images that will be used for the items pictures.
 * @Author Adrian Lopez
 * @since <pre>Jun 22, 2015</pre>
 * @version 1.0
 */
@Controller
public class UploadController {

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
        if(!file.isEmpty()){
            try {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(file.getBytes());
                stream.close();
            } catch (IOException ex) {
                return "Failed to upload due to: " + ex.getMessage();
            }

        }
        return "Failed to upload file";
    }
}
