package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers.
 * A 20 percent discount is applied.
 *
 * Author: Gabrielle Taylor
 */
public class VIPDiscount implements DiscountStrategy {

    /**
     * Returns the price after a 20 percent discount.
     *
     * @param price the original purchase price
     * @return the final price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}