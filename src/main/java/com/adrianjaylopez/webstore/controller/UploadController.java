package com.adrianjaylopez.webstore.controller;

import com.adrianjaylopez.webstore.dao.Image;
import com.adrianjaylopez.webstore.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.Iterator;

/**
 * This class is going to deal with uploading the images that will be used for the items pictures.
 * @author Adrian J Lopez
 * @since <pre>6/22/15</pre>
 * @version 2.0
 */
@RestController
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * Used to upload picture images to the database for storage.
     * @param request holds the images and their metadata
     * @return failed or success
     */
    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String fileUpload(MultipartHttpServletRequest request){
        try {
            //iterate over the request and grab the image names
            for(Iterator<String> fileName = request.getFileNames(); fileName.hasNext();){
                //get the file using the image name and set it to this file
                MultipartFile file = request.getFile(fileName.next());
                //create image object
                Image image = new Image(file.getOriginalFilename(), file.getBytes(), file.getContentType(),
                        Integer.parseInt(request.getParameter("viewOrder")));
                //pass in image to upload service for storage
                uploadService.uploadImage(image);

            }
        } catch (IOException e) {
        return "failed";
    }
        return "success";
    }
}
