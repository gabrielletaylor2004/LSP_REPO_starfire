package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents a pricing strategy used to calculate
 * the final purchase price.
 *
 * Author: Gabrielle Taylor
 */
public abstract class DiscountStrategy {

    /**
     * Calculates the final price based on the strategy.
     *
     * @param price the original purchase price
     * @return the final calculated price
     */
    public abstract double calculatePrice(double price);
}