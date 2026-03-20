package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for regular customers.
 * No discount is applied.
 *
 * Author: Gabrielle Taylor
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price with no discount.
     *
     * @param price the original purchase price
     * @return the final price
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}