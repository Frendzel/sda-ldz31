package pl.sda.chuck.dao;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Mocked DB
 */
@Data
public class JokesMockedDb {
    private List<JokeEntity> jokes = new ArrayList<>();
}
