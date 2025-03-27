package testTransformacaoDeDados;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void salvarComoCSV(List<String[]> tabela, String csvPath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvPath))) {
            writer.writeAll(tabela);
        }
    }
}
