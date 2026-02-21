package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a Product entity used in the ETL pipeline.
 * 
 * This class demonstrates encapsulation by keeping fields private
 * and exposing controlled access through public getter and setter methods.
 * 
 * @author Gabrielle Taylor
 */
public class Product {

    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    /**
     * Constructs a Product object with the specified values.
     *
     * @param productId the unique product identifier
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name the updated product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price the updated product price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the product category.
     *
     * @param category the updated product category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the price range classification of the product.
     *
     * @return the price range (Low, Medium, High, Premium)
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the price range classification.
     *
     * @param priceRange the computed price range
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Converts this Product object into a CSV-formatted string.
     *
     * @return a CSV representation of the product
     */
    public String toCsv() {
        return productId + "," +
               name + "," +
               price.toString() + "," +
               category + "," +
               priceRange;
    }
}