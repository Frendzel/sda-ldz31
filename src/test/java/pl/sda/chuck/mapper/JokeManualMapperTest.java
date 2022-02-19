package pl.sda.chuck.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.dto.JokeValue;
import pl.sda.chuck.exception.ExternalTechnicalException;

import java.util.List;
import java.util.Optional;

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
        assertEquals(testedObject.getValue().getJoke(), result.getJoke());
        assertEquals(testedObject.getValue().getCategories(), result.getCategories());
        assertEquals(1, result.getExternalId());
        assertEquals(null, result.getId());
    }

    @Test
    @DisplayName("Testing mapping between Optional DTO and Entity using ManualMapper - Positive")
    void mapOptionalDtoToEntityPositiveTest() {
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
        JokeEntity result = map(Optional.of(testedObject));
        //then -> assertion
        Assertions.assertNotNull(result);
        assertEquals(testedObject.getValue().getJoke(), result.getJoke());
        assertEquals(testedObject.getValue().getCategories(), result.getCategories());
        assertEquals(1, result.getExternalId());
        assertEquals(null, result.getId());
    }

    @Test
    @DisplayName("Testing mapping between Optional DTO and Entity using ManualMapper - Negative")
    void testMapNegative() {
//        try {
//            JokeEntity result = map(Optional.of(Joke.builder().build()));
//            fail();
//        } catch (Exception e) {
//            Assertions.assertNotNull(e);
//        }
        Assertions.assertThrows(ExternalTechnicalException.class, () -> map(Optional.of(builder().build())));
    }

    @Test
    //consider name of method
    @Disabled
        // junit 4 -> @Ignore
    void mapDtoToEntityNegative() {
        //given -> object to compare
        //when -> map method
        JokeEntity result = map(builder().build());
        //then -> assertion
        Assertions.assertNotNull(result);
    }
}