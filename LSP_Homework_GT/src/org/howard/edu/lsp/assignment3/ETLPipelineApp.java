package org.howard.edu.lsp.assignment3;

/**
 * Entry point for ETL Pipeline.
 *
 * This class is responsible only for launching the application.
 *
 * @author Gabrielle Taylor
 */
public class ETLPipelineApp {

    /**
     * Main method that starts the ETL process.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        ETLProcessor processor = new ETLProcessor();
        processor.process(inputPath, outputPath);
    }
}