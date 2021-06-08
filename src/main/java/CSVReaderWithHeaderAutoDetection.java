
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CSVReaderWithHeaderAutoDetection {
    private static final String SAMPLE_CSV_FILE_PATH = "masini.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String ID = csvRecord.get("ID");
                String Marca = csvRecord.get("Marca");
                String Model = csvRecord.get("Model");
                String Combustibil = csvRecord.get("Combustibil");
                String An = csvRecord.get("An");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Id : " + ID);
                System.out.println("Marca : " + Marca);
                System.out.println("Model : " + Model);
                System.out.println("Combustibil : " + Combustibil);
                System.out.println("An : " + An);
                System.out.println("---------------\n\n");
            }
        }
    }
}
