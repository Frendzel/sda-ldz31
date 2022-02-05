package pl.sda.chuck.reports;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.chuck.dao.JokeEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class CsvGenerator implements Generator {
    @Override
    public void generate(List<JokeEntity> jokes) {
        //try-with-resources construction to close csvPrinter
        try (FileWriter fileWriter = new FileWriter("jokes.csv");
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {
            //TODO
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
