package pl.sda.chuck.reports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportFactory {

    @Value("${report.target.path}")
    private String path;

    public Generator createGenerator(GeneratorType generatorType) {
        switch (generatorType) {
            case PDF -> {
                return new PdfGenerator(path);
            }
            case CSV -> {
                return new CsvGenerator(path);
            }
            case EXCEL -> {
                return new ExcelGenerator(path);
            }
            default -> throw new IllegalStateException("Unexpected value: " + generatorType);
        }
    }
}
