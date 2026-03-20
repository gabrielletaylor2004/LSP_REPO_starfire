package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for holiday customers.
 * A 15 percent discount is applied.
 *
 * Author: Gabrielle Taylor
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Returns the price after a 15 percent discount.
     *
     * @param price the original purchase price
     * @return the final price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}