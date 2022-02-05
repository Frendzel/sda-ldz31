package pl.sda.chuck.reports;

import pl.sda.chuck.dao.JokeEntity;

import java.util.List;

public interface Generator {

    void generate(List<JokeEntity> jokes);
}
