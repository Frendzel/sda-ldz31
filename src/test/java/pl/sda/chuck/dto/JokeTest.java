package pl.sda.chuck.dto;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JokeTest {

    private static final String SUCCESS = "SUCCESS";

    //given
    Gson gson = new Gson();

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

        //then
        assertTrue(result.contains("\"type\":SUCCESS"));
        assertTrue(result.contains("\"value\":{\"id\":1,\"joke\":\"Very funny joke\",\"categories\":[\"nerdy\"]}"));
    }

    @Test
    @DisplayName("Serialization test for Json to Joke dto - positive")
    public void jsonToPojoTest() {

        //given
        String jsonFirst = "{\n" +
                "\t\"type\": SUCCESS,\n" +
                "\t\"value\": {\n" +
                "\t\t\"id\": 145,\n" +
                "\t\t\"joke\": \"Chuck Norris is currently suing myspace for taking the name of what he calls everything around you.\",\n" +
                "\t\t\"categories\": []\n" +
                "\t}\n" +
                "}";

        //when
        Joke jokeDto = gson.fromJson(jsonFirst, Joke.class);

        //then
        Assertions.assertEquals(jokeDto.type, SUCCESS);
        Assertions.assertEquals(jokeDto.value.id, 145);
        //etc

        //when
        //gson --> json

        //then
        //compare json final with json first


    }

}