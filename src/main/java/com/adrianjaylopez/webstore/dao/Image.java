package com.adrianjaylopez.webstore.dao;

import java.io.Serializable;

/**
 * This class stores image information from the database. This information is used to find the path for the image,the
 * item that the image corresponds to, and the order that the images should be displayed in.
 * @author Adrian J Lopez
 */
public class Image implements Serializable{

    //declare variables
    private String itemNumber, fileName;
    private int viewOrder;

    /**
     * Constructor to create image object.
     * @param itemNumber Alphanumerical number for the item
     * @param viewOder Order in which the images should be displayed
     */
    public Image(String itemNumber, int viewOder){
        this.itemNumber = itemNumber;
        this.viewOrder = viewOder;
        setFileName();
    }

    /**
     * Private no-arg contructor for hibernate
     */
    private Image(){}

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
     * Sets the file name of this image using the item number and the view order. Method is private so app sets name to
     * avoid duplicate names
     */
    private void setFileName() {
        this.fileName = itemNumber + "-" + viewOrder;
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
