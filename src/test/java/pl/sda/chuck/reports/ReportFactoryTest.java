package pl.sda.chuck.reports;

import org.junit.jupiter.api.Test;

class ReportFactoryTest {

    @Test
    void createGenerator() {
        ReportFactory reportFactory = new ReportFactory();
        Generator generator = reportFactory.createGenerator(GeneratorType.PDF);
        generator.generate(null);
    }
}