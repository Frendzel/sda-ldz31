package pl.sda.chuck.reports;

import pl.sda.chuck.dao.JokeEntity;

import java.util.List;

public sealed interface Generator permits CsvGenerator, ExcelGenerator, PdfGenerator {
    String[] HEADERS = {"ID", "EXTERNAL_ID", "JOKE"};

    void generate(List<JokeEntity> jokes);
}
