package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Handles transformation logic for Product objects in the ETL pipeline.
 *
 * This class demonstrates separation of concerns
 * by isolating transformation logic from file processing logic.
 *
 *
 * @author Gabrielle Taylor
 */
public class ProductTransformer {

    /**
     * Applies all required transformations to the given Product.
     *
     *
     * @param product the Product object to transform
     */
    public void transform(Product product) {

        // 1. Convert name to uppercase
        product.setName(product.getName().toUpperCase());

        boolean wasElectronics = product.getCategory().equals("Electronics");
        BigDecimal price = product.getPrice();

        // 2. Apply discount
        if (wasElectronics) {
            price = price.multiply(new BigDecimal("0.90"));
        }

        // 3. Round price
        price = price.setScale(2, RoundingMode.HALF_UP);
        product.setPrice(price);

        // 4. Upgrade category if applicable
        if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
            product.setCategory("Premium Electronics");
        }

        // 5. Determine price range
        String priceRange;

        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            priceRange = "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            priceRange = "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }

        product.setPriceRange(priceRange);
    }
}