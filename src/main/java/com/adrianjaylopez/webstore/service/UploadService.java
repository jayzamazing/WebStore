package com.adrianjaylopez.webstore.service;

import com.adrianjaylopez.webstore.dao.Image;
import com.adrianjaylopez.webstore.dao.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ImageRepository imageRepository;

    /**
     * gets the image file
     * @param filename name of file
     * @return image file
     */
    public Image findByFilename(String filename){
        return imageRepository.findByFilename(filename);
    }

    /**
     * uploads the image file
     * @param img file to upload
     */
    public void uploadImage(Image img){
        imageRepository.saveAndFlush(img);
    }
}
