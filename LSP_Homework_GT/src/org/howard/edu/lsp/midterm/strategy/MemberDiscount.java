package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for member customers.
 * A 10 percent discount is applied.
 *
 * Author: Gabrielle Taylor
 */
public class MemberDiscount extends DiscountStrategy {

    /**
     * Returns the price after a 10 percent discount.
     *
     * @param price the original purchase price
     * @return the final price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}