package pl.sda.chuck.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

class JokeTest {

    @Test
    public void pojoToJsonTest() {
        Joke joke = Joke.builder()
                .type("SUCCESS")
                .value(JokeValue.builder()
                        .joke("Very funny joke")
                        .id(1)
                        .categories(List.of("nerdy"))
                        .build())
                .build();

        System.out.println(joke);
    }

}