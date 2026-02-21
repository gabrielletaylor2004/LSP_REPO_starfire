package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;

/**
 * Coordinates the Extract and Load phases of the ETL pipeline.
 *
 * This design improves modularity compared to Assignment 2
 * by separating file processing from transformation logic.
 *
 * @author Gabrielle Taylor
 */
public class ETLProcessor {

    private int rowsRead = 0;
    private int rowsWritten = 0;
    private int rowsSkipped = 0;

    private final ProductTransformer transformer = new ProductTransformer();

    /**
     * Executes the ETL process using the provided input and output paths.
     *
     * The method preserves the exact behavior and output format
     * from Assignment 2, including:
     * - Missing input file handling
     * - Empty file handling
     * - Data validation and row skipping
     * - Summary reporting
     *
     * @param inputPath relative path to input CSV file
     * @param outputPath relative path to output CSV file
     */
    public void process(String inputPath, String outputPath) {

        File inputFile = new File(inputPath);

        // Missing file handling
        if (!inputFile.exists()) {
            System.err.println("Error: Input file not found at " + inputPath);
            return;
        }

        File outDir = new File("data");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String header = br.readLine();

            if (header == null) {
                bw.write("ProductID,Name,Price,Category,PriceRange");
                bw.newLine();
                printSummary(outputPath);
                return;
            }

            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            String line;

            while ((line = br.readLine()) != null) {

                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",");

                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productId = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();

                    Product product = new Product(productId, name, price, category);

                    transformer.transform(product);

                    bw.write(product.toCsv());
                    bw.newLine();

                    rowsWritten++;

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            return;
        }

        printSummary(outputPath);
    }

    /**
     * Prints a summary of ETL execution results.
     *
     * @param outputPath the output file location
     */
    private void printSummary(String outputPath) {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsWritten);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}