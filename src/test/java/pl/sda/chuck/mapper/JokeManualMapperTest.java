package pl.sda.chuck.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.dto.JokeValue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sda.chuck.dto.Joke.builder;
import static pl.sda.chuck.mapper.JokeManualMapper.map;

class JokeManualMapperTest {

    @Test
    @DisplayName("Testing mapping between DTO and Entity using ManualMapper - Positive")
    void mapDtoToEntityPositiveTest() {
        //given -> object to compare
        Joke testedObject = builder()
                .value(JokeValue
                        .builder()
                        .joke("Very funny joke")
                        .id(1)
                        .categories(List.of("nerdy"))
                        .build())
                .type("SUCCESS")
                .build();
        //when -> map method
        JokeEntity result = map(testedObject);
        //then -> assertion
        assertEquals(result.getJoke(), testedObject.getValue().getJoke());
        assertEquals(result.getCategories(), testedObject.getValue().getCategories());
    }

    @Test
        //consider name of method
    void mapDtoToEntityNegative() {
        //given -> object to compare
        //when -> map method
        JokeEntity result = map(builder().build());
        //then -> assertion
        Assertions.assertNotNull(result);
    }

    @Test
        //consider name of method
    void testMap() {
        //given -> object to compare
        //when -> map method
        //then -> assertion
    }
}