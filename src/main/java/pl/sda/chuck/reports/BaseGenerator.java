package pl.sda.chuck.reports;

public abstract sealed class BaseGenerator permits CsvGenerator, ExcelGenerator, PdfGenerator {

    protected String path;
}
