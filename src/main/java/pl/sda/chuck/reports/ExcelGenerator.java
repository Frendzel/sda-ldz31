package pl.sda.chuck.reports;

import pl.sda.chuck.dao.JokeEntity;

import java.util.List;

public final class ExcelGenerator extends BaseGenerator implements Generator {

    public ExcelGenerator(String path) {
        this.path = path;
    }

    @Override
    public void generate(List<JokeEntity> jokes) {
        //TODO
    }
}
