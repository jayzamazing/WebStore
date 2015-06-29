package com.adrianjaylopez.webstore.dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import static org.junit.Assert.*;

/**
 * Image Tester.
 * This class is to run tests on the item class.
 * @version 1.1
 * @Author Adrian J Lopez
 * @since <pre>6/25/15</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Image.class)
public class ImageTest {
    //declarations
    @Autowired
    Image image;

    Field field;

    /**
     * Using a tear down method to reset field and image to null so that each method tests only the
     * data it sets.
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        field = null;//reset variables
        image = null;
    }

    /**
     * Tests to ensure that get method for view order is working.
     * @throws Exception
     */
    @Test
    public void testGetViewOrder() throws Exception {
        reflectionSetHelper("viewOrder", 3, image);//setter
        assertEquals(image.getViewOrder(), 3);//check this method produced expected results
    }

    /**
     * Tests setvieworder method.
     * @throws Exception
     */
    @Test
    public void testSetViewOrder() throws Exception {
        image.setViewOrder(5);//setter
        assertEquals((int)reflectionGetHelper("viewOrder", image), 5);//check this method produced expected results
    }

    /**
     * Tests getitemnumber method.
     * @throws Exception
     */
    @Test
    public void testGetItemNumber() throws Exception {
        reflectionSetHelper("itemNumber", "A43281-9", image);//setter
        assertEquals(image.getItemNumber(), "A43281-9");//check this method produced expected results
    }

    /**
     * Tests setitenumber method.
     * @throws Exception
     */
    @Test
    public void testSetItemNumber() throws Exception {
        image.setItemNumber("A43281-9");//setter
        assertEquals(reflectionGetHelper("itemNumber", image), "A43281-9");//check this method produced expected results
    }

    /**
     * Tests getfilename method.
     * @throws Exception
     */
    @Test
    public void testGetFileName() throws Exception {
        reflectionSetHelper("fileName", "superblah", image);//setter
        assertEquals(image.getFileName(), "superblah");//check this method produced expected results
    }

    /**
     * Test setfilename method.
     * @throws Exception
     */
    @Test
    public void testSetFileName() throws Exception {
        image.setFileName("super mario bros");//setter
        assertEquals(reflectionGetHelper("fileName", image), "super mario bros");//check this method produced expected results
    }

    /**
     * Test getfile method.
     * @throws Exception
     */
    @Test
    public void testGetFile() throws Exception {
        File file = new File("/Users/jay/Pictures/family pic.jpg");//create file object of an image
        MultipartFile mFile = new MockMultipartFile(file.getName(), Files.newInputStream(file.toPath(),
                StandardOpenOption.READ));//create multipart file and pass file to it
        reflectionSetHelper("file", mFile, image);//setter
        assertEquals(image.getFile(), mFile);//check this method produced expected results
    }

    /**
     * Tests the setfile method.
     * @throws Exception
     */
    @Test
    public void testSetFile() throws Exception {
        File file = new File("/Users/jay/Pictures/family pic.jpg");//create file object of an image
        MultipartFile mFile = new MockMultipartFile(file.getName(), Files.newInputStream(file.toPath(),
                StandardOpenOption.READ));//create multipart file and pass file to it
        image.setFile(mFile);
        assertEquals(reflectionGetHelper("file", image), mFile);//check this method produced expected results
    }

    /**
     * Test to string method.
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        reflectionSetHelper("itemNumber", "D3985", image);//Setters
        reflectionSetHelper("viewOrder", 3, image);
        reflectionSetHelper("fileName", "D398532", image);
        assertEquals(image.toString(), "Image{itemNumber='D3985', viewOrder=3, fileName=D398532}");//check this method
        // produced expected results
    }

    /**
     * Helper method for getting a field without using a getter.
     * @param fieldName name of field I am trying to gleam
     * @return Object inside field
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private <T> Object reflectionGetHelper(String fieldName, T instance) throws NoSuchFieldException, IllegalAccessException {
        field = instance.getClass().getDeclaredField(fieldName);//get the field from the class
        field.setAccessible(true);//allows modification of the field
        return field.get(instance);//return the object for the field
    }

    /**
     * Helper method for setting a field without using setter.
     * @param fieldName name of the field I am trying to gleam
     * @param data the data that will be passed into the field
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private <T> void reflectionSetHelper(String fieldName, Object data, T instance) throws NoSuchFieldException, IllegalAccessException {
        field = instance.getClass().getDeclaredField(fieldName); //get the field from the class
        field.setAccessible(true);//allows modification of the field
        field.set(instance, data);//set the data for this field
    }


}