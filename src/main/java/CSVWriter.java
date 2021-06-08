
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "masini.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Marca", "Model", "Combustibil","An"));
        ) {
            csvPrinter.printRecord("1", "BMW", "X6M", "benzina","2016");
            csvPrinter.printRecord("2", "Mercedes", "C63", "benzina","2014");
            csvPrinter.printRecord("3", "Renault", "Megane", "motorina","2010");

            csvPrinter.printRecord(Arrays.asList("5", "Volkswagen", "Golf", "benzina","2020"));

            csvPrinter.flush();
        }
    }
}
