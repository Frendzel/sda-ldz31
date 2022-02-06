package pl.sda.chuck.reports;

import pl.sda.chuck.dao.JokeEntity;

import java.util.List;

public final class PdfGenerator extends BaseGenerator implements Generator {

    private static final String EXTENSION = ".pdf";

    public PdfGenerator(String path) {
        this.path = path;
    }

    @Override
    public void generate(List<JokeEntity> jokes) {
        //TODO library to be used: https://mvnrepository.com/artifact/com.itextpdf/itextpdf
    }
}
