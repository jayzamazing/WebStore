package com.adrianjaylopez.webstore.dao;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 *This class stores item information from the database. The information includes the item number, and description, its
 * price, along with an associated collection of images.
 * @author Adrian J Lopez
 * @since <pre>6/16/15</pre>
 * @version 1.3
 */

public class Item {

    //declare variables
    private String itemNumber, description;
    private BigDecimal price;

    //@Autowired//App context injects instance of
    private HashMap<Integer, Image> images;

    /**
     * no-arg constructor
     */
    public Item(){}

    /**
     * Gets the price of the item
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price for the item
     * @param price item cost
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the items number
     * @return item number
     */
    public String getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the item number
     * @param itemNumber items number
     */
    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    /**
     * Gets the items description
     * @return item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the item
     * @param description of item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get hashmap of images
     * @return all images associated with item
     */
    public HashMap<Integer, Image> getImages() {
        return images;
    }

    /**
     * Set images hash map.
     * @param images integer positions, image names
     */
    private void setImages(HashMap<Integer, Image> images) {
        this.images = images;
    }

    /**
     * toString method returning items description, number, price and associated images
     * @return
     */
    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", itemNumber='" + itemNumber + '\'' +
                ", price=" + price +
                ", images=" + images +
                '}';
    }
}
