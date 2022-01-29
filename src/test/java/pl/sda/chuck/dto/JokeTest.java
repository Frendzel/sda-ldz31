package pl.sda.chuck.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JokeTest {

    private static final String SUCCESS = "SUCCESS";
    public static final String EMPTY_STRING = "";

    //given
    Gson gson = new Gson();

    @Test
    @DisplayName("Joke value cannot be empty - negative")
    public void validationTest() {
        //given
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Joke joke = Joke.builder()
                .type(SUCCESS)
                .value(JokeValue.builder()
                        .joke("")
                        .id(1)
                        .categories(List.of("nerdy"))
                        .build())
                .build();
        //when
        Set<ConstraintViolation<Joke>> violations = validator.validate(joke);
        //then
        assertFalse(violations.isEmpty());
        violations.forEach(jokeConstraintViolation -> {
            assertEquals("nie może być odstępem", jokeConstraintViolation.getMessage());
        });
    }

    @Test
    @DisplayName("Serialization test for Joke dto to json - positive")
    public void pojoToJsonTest() {
        //given
        Joke joke = Joke.builder()
                .type(SUCCESS)
                .value(JokeValue.builder()
                        .joke("Very funny joke")
                        .id(1)
                        .categories(List.of("nerdy"))
                        .build())
                .build();

        //when
        String result = gson.toJson(joke);
        //show joke serialized in standard way
        System.out.println(result);
        GsonBuilder gsonBuilder = new GsonBuilder();
        //show joke serialized in pretty way
        String prettyResult = gsonBuilder
                .setPrettyPrinting()
                .create()
                .toJson(joke);
        System.out.println(prettyResult);

        //then
        assertTrue(result.contains("\"type\":\"SUCCESS\""));
        assertTrue(result.contains("\"value\":{\"id\":1,\"joke\":\"Very funny joke\",\"categories\":[\"nerdy\"]}"));
    }

    @Test
    @DisplayName("Serialization test for Json to Joke dto - positive")
    public void jsonToPojoTest() {

        //given
        String jsonFirst = "{\n" +
                "\t\"type\":\"SUCCESS\",\n" +
                "\t\"value\":{\n" +
                "\t\t\"id\":145,\n" +
                "\t\t\"joke\":\"Chuck Norris is currently suing myspace for taking the name of what he calls everything around you.\",\n" +
                "\t\t\"categories\":[]\n" +
                "\t}\n" +
                "}";

        //when
        Joke jokeDto = gson.fromJson(jsonFirst, Joke.class);

        //then
        assertEquals(jokeDto.type, SUCCESS);
        assertEquals(jokeDto.value.id, 145);
        //etc

        //when
        String result = gson.toJson(jokeDto);
        //then
        assertEquals(StringUtils.replaceIsoControlCharacters(jsonFirst, EMPTY_STRING), result);

    }

}