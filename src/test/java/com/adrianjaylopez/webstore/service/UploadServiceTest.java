package com.adrianjaylopez.webstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.*;

/**
 * @version 1.0
 * @Author Adrian J Lopez
 * @since <pre>6/27/15</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UploadService.class)

public class UploadServiceTest {

    @Autowired
    UploadService uploadService;

    @Test
    public void testImageUpload() throws Exception {
        /**
        File file = new File("/Users/jay/Pictures/family pic.jpg");
        MultipartFile mFile = new MockMultipartFile(file.getName(), Files.newInputStream(file.toPath(), StandardOpenOption.READ));
        image.setFile(mFile);
        mFile.transferTo(new File("family pic.jpg"));
        assertEquals(image.getFile(), mFile);

         **/
    }
}