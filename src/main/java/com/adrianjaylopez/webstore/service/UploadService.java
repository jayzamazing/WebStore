package com.adrianjaylopez.webstore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @author Adrian J Lopez
 * @since <pre>6/26/15</pre>
 */
@Service
public class UploadService {

    public String imageUpload(String name, MultipartFile file){
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
