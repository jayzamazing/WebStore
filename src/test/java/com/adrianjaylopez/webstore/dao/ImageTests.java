package com.adrianjaylopez.webstore.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This class is to run tests on the item class.
 * @author Adrian J Lopez
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
        image.setFileName();
        //check expected values against what is in the instance
        Assert.assertEquals(image.getItemNumber(), "D3985");
        Assert.assertEquals(image.getViewOrder(), 3);
        Assert.assertEquals(image.getFileName(), "D3985-3");
        Assert.assertEquals(image.toString(), "Image{itemNumber='D3985', viewOrder=3, fileName=D3985-3}");


    }
}
