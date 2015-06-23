package com.adrianjaylopez.webstore.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Image Tester.
 * This class is to run tests on the item class.
 * @author Adrian J Lopez
 * @since <pre>Jun 18, 2015</pre>
 * @version 1.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Image.class)
public class ImageTests {
    /**
     * This method creates an instance of the class and tests the expected values.
     */
    @Test
    public void testItems(){
        Image image = new Image();//create instance
        //set variables for instance
        image.setItemNumber("D3985");
        image.setViewOrder(3);
        image.setFileName("D398532");
        //check expected values against what is in the instance
        Assert.assertEquals(image.getItemNumber(), "D3985");
        Assert.assertEquals(image.getViewOrder(), 3);
        Assert.assertEquals(image.getFileName(), "D398532");
        Assert.assertEquals(image.toString(), "Image{itemNumber='D3985', viewOrder=3, fileName=D398532}");


    }

    /**
     *
     * Method: getViewOrder()
     *
     */
    @Test
    public void testGetViewOrder() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setViewOrder(int viewOrder)
     *
     */
    @Test
    public void testSetViewOrder() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: getItemNumber()
     *
     */
    @Test
    public void testGetItemNumber() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setItemNumber(String itemNumber)
     *
     */
    @Test
    public void testSetItemNumber() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: getFileName()
     *
     */
    @Test
    public void testGetFileName() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setFileName(String fileName)
     *
     */
    @Test
    public void testSetFileName() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: getFile()
     *
     */
    @Test
    public void testGetFile() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setFile(MultipartFile file)
     *
     */
    @Test
    public void testSetFile() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: toString()
     *
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here...
    }
}
