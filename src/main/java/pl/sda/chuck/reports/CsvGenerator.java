package pl.sda.chuck.reports;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.chuck.dao.JokeEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public final class CsvGenerator extends BaseGenerator implements Generator {

    private static final String EXTENSION = ".csv";

    public CsvGenerator(String path) {
        this.path = path;
    }

    @Override
    public void generate(List<JokeEntity> jokes) {
        log.info("Trying to save file on given path: {}", path);
        //try-with-resources construction to close csvPrinter
        try (FileWriter fileWriter = new FileWriter(path + EXTENSION);
             CSVPrinter csvPrinter = new CSVPrinter(
                     fileWriter,
                     CSVFormat.Builder.create()
                             .setHeader(HEADERS)
                             .setDelimiter(";")
                             .build()
             )
        ) {
            for (JokeEntity joke : jokes) {
                csvPrinter.printRecord(joke.getId(), joke.getExternalId(), joke.getJoke());
            }
            csvPrinter.flush();
            fileWriter.flush();
            log.info("Successfully saved file");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("Successfully saved file");
    }
}
