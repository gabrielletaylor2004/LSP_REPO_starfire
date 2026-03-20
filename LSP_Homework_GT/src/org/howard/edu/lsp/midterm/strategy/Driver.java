package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern implementation
 * for price calculation.
 *
 * Author: Gabrielle Taylor
 */
public class Driver {

    /**
     * Runs the driver program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double price = 100.0;

        PriceCalculator calculator = new PriceCalculator(new RegularDiscount());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new MemberDiscount());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new VIPDiscount());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}