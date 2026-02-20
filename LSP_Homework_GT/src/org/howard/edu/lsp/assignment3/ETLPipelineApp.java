package org.howard.edu.lsp.assignment3;

/**
 * Entry point for Assignment 3 ETL Pipeline.
 *
 * This class is responsible only for launching the application.
 * It delegates processing responsibilities to ETLProcessor,
 * demonstrating separation of concerns and modular design.
 *
 * The program preserves identical functionality and file paths
 * from Assignment 2.
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