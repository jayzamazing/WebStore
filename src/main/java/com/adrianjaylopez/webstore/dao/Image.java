package com.adrianjaylopez.webstore.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Image Class
 *
 * This class stores image information from the database. This information is used to find the path for the image,the
 * item that the image corresponds to, and the order that the images should be displayed in.
 * @author Adrian J Lopez
 * @since <pre>6/6/15</pre>
 * @version 2.0
 */
@Entity
@Table(name = "Images")
public class Image {

    //declare variables
    @Id @GeneratedValue
    @Column
    private Long id;

    @NotNull
    private String filename;

    @NotNull
    private int viewOrder;

    @NotNull
    @Lob
    private byte[] file;

    @NotNull
    private String mimeType;

    /**
     * no-arg constructor
     */
    public Image(){}

    public Image(String filename, byte[] file, String mimeType, int viewOrder){
        this.filename = filename;
        this.file = file;
        this.mimeType = mimeType;
        this.viewOrder = viewOrder;
    }

    /**
     * get auto generated id
     * @return id number
     */
    public Long getId() {
        return id;
    }

    /**
     * set auto generated id
     * @param id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * Gets the file name for this image
     * @return file name
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the file name of this image using the item number and the view order.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets the picture file.
     * @return file
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * Sets the picture file.
     * @param file picture
     */
    public void setFile(byte[] file) {
        this.file = file;
    }

    /**
     * gets the mime type of the image
     * @return mime type
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * sets the mime type for the file
     * @param mimeType
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * toString method to to show the item number, order number, file path for the image, and name of file
     * @return item number, order number, and file path
     */
    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", viewOrder=" + viewOrder +
                ", mimeType=" + mimeType +
                '}';
    }
}
