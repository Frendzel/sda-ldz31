package pl.sda.chuck.reports;

public class ReportFactory {

    public Generator createGenerator(GeneratorType generatorType) {
        switch (generatorType) {
            case PDF -> {
                return new PdfGenerator();
            }
            case CSV -> {
                return new CsvGenerator();
            }
            case EXCEL -> {
                return new ExcelGenerator();
            }
            default -> throw new IllegalStateException("Unexpected value: " + generatorType);
        }
    }
}
