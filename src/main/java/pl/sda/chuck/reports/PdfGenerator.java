package pl.sda.chuck.reports;

import pl.sda.chuck.dao.JokeEntity;

import java.util.List;

public final class PdfGenerator extends BaseGenerator implements Generator {

    public PdfGenerator(String path) {
        this.path = path;
    }

    @Override
    public void generate(List<JokeEntity> jokes) {
        //TODO
    }
}
