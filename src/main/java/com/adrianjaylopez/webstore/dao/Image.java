package com.adrianjaylopez.webstore.dao;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Image Class
 *
 * This class stores image information from the database. This information is used to find the path for the image,the
 * item that the image corresponds to, and the order that the images should be displayed in.
 * @author Adrian J Lopez
 * @since <pre>Jun 16, 2015</pre>
 * @version 1.3
 */
@Entity
public class Image {

    //declare variables
    @Id @GeneratedValue
    private Long id;

    private String itemNumber, fileName;
    private int viewOrder;
    private MultipartFile file;

    /**
     * no-arg constructor
     */
    public Image(){}

    /**
     * Gets the order number for the image
     * @return order number
     */
    public int getViewOrder() {
        return viewOrder;
    }

    /**
     * Sets the view order number for the image
     * @param viewOrder number for the position of the image
     */
    public void setViewOrder(int viewOrder) {
        this.viewOrder = viewOrder;
    }

    /**
     * Gets the item number that the image is associated with
     * @return item number
     */
    public String getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the item number this image is associated with
     * @param itemNumber item number
     */
    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    /**
     * Gets the file name for this image
     * @return file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name of this image using the item number and the view order.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the picture file. Not persisted.
     * @return file
     */
    @Transient
    public MultipartFile getFile() {
        return file;
    }

    /**
     * Sets the picture file. Not persisted
     * @param file picture
     */
    @Transient
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * toString method to to show the item number, order number, and file path for the image
     * @return item number, order number, and file path
     */
    @Override
    public String toString() {
        return "Image{" +
                "itemNumber='" + itemNumber + '\'' +
                ", viewOrder=" + viewOrder +
                ", fileName=" + fileName +
                '}';
    }





}
