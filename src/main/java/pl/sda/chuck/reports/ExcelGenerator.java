package pl.sda.chuck.reports;

import pl.sda.chuck.dao.JokeEntity;

import java.util.List;

public final class ExcelGenerator extends BaseGenerator implements Generator {

    private static final String EXTENSION = ".xls";

    public ExcelGenerator(String path) {
        this.path = path;
    }

    @Override
    public void generate(List<JokeEntity> jokes) {
        //TODO add support usinghttps://mvnrepository.com/artifact/org.apache.poi/poi
    }
}
