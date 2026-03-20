package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates the final purchase price by delegating
 * to a discount strategy.
 *
 * Author: Gabrielle Taylor
 */
public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    /**
     * Constructs a PriceCalculator with the given strategy.
     *
     * @param discountStrategy the pricing strategy to use
     */
    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Sets the pricing strategy.
     *
     * @param discountStrategy the new pricing strategy
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the current strategy.
     *
     * @param price the original purchase price
     * @return the final calculated price
     * @throws IllegalStateException if no strategy has been set
     */
    public double calculatePrice(double price) {
        if (discountStrategy == null) {
            throw new IllegalStateException("Discount strategy is not set.");
        }
        return discountStrategy.calculatePrice(price);
    }
}