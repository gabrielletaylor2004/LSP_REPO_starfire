package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

	/**
	 * Name: Gabrielle Taylor
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        File inputFile = new File(inputPath);

        // --- Case C: Missing input file ---
        if (!inputFile.exists()) {
            System.err.println("Error: Input file not found at " + inputPath);
            return; // clean exit, no stack trace
	}
        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        // Ensure output directory exists
        File outDir = new File("data");
        if (!outDir.exists()) {
            outDir.mkdirs();
    }
    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
         BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

         String header = br.readLine();

         // If file is empty (no header), still create output with header
         if (header == null) {
             bw.write("ProductID,Name,Price,Category,PriceRange");
             bw.newLine();
             System.out.println("Rows read: 0");
             System.out.println("Rows transformed: 0");
             System.out.println("Rows skipped: 0");
             System.out.println("Output written to: " + outputPath);
             return;
          }

          // Write output header
          bw.write("ProductID,Name,Price,Category,PriceRange");
          bw.newLine();
          
          String line;
          while ((line = br.readLine()) != null) {

              rowsRead++;

              // Skip blank lines
              if (line.trim().isEmpty()) {
                  rowsSkipped++;
                  continue;
              }

              String[] fields = line.split(",");

              // Must have exactly 4 fields
              if (fields.length != 4) {
                  rowsSkipped++;
                  continue;
              }

              String idStr = fields[0].trim();
              String name = fields[1].trim();
              String priceStr = fields[2].trim();
              String category = fields[3].trim();

              int productId;
              BigDecimal price;          
              // Parse ProductID
              try {
                  productId = Integer.parseInt(idStr);
              } catch (NumberFormatException e) {
                  rowsSkipped++;
                  continue;
              }

              // Parse Price
              try {
                  price = new BigDecimal(priceStr);
              } catch (NumberFormatException e) {
                  rowsSkipped++;
                  continue;
              }

              // -------- TRANSFORMATIONS (IN EXACT ORDER) --------

              // 1. Name to UPPERCASE
              name = name.toUpperCase();

              // 2. If Electronics, apply 10% discount
              boolean wasElectronics = category.equals("Electronics");

              if (wasElectronics) {
                  price = price.multiply(new BigDecimal("0.90"));
              }

              // Round to exactly two decimal places (HALF_UP)
              price = price.setScale(2, RoundingMode.HALF_UP);

              // 3. If final price > 500 AND originally Electronics -> Premium Electronics
              if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                  category = "Premium Electronics";
              }

              // 4. Determine PriceRange based on final price
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

              // -------- WRITE OUTPUT ROW --------
              bw.write(
            	        productId + "," +
            	        name + "," +
            	        price.toString() + "," +
            	        category + "," +
            	        priceRange
              );
              bw.newLine();

              rowsWritten++;
          }

      } catch (IOException e) {
          System.err.println("Error processing files: " + e.getMessage());
          return;
      }

      // -------- RUN SUMMARY --------
      System.out.println("Rows read: " + rowsRead);
      System.out.println("Rows transformed: " + rowsWritten);
      System.out.println("Rows skipped: " + rowsSkipped);
      System.out.println("Output written to: " + outputPath);
  }
}