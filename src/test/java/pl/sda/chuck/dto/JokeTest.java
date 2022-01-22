package pl.sda.chuck.dto;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JokeTest {

    //given
    Gson gson = new Gson();

    @Test
    @DisplayName("Serialization test for Joke dto - positive")
    public void pojoToJsonTest() {
        //given
        Joke joke = Joke.builder()
                .type("SUCCESS")
                .value(JokeValue.builder()
                        .joke("Very funny joke")
                        .id(1)
                        .categories(List.of("nerdy"))
                        .build())
                .build();

        //when
        String result = gson.toJson(joke);

        //then
        assertTrue(result.contains("\"type\":\"SUCCESS\""));
        assertTrue(result.contains("\"value\":{\"id\":1,\"joke\":\"Very funny joke\",\"categories\":[\"nerdy\"]}"));
    }

}