package pl.sda.chuck.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.chuck.dto.CountResponse;
import pl.sda.chuck.dto.Joke;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    JokeService jokeService;

    @Test
    @DisplayName("Should return 574 jokes asking for count - positive")
    void countJokes() {
        //when
        Optional<CountResponse> countResponse = jokeService.countJokes();
        //then
        assertEquals(574, jokeService.countJokes().map(CountResponse::getValue).orElseThrow());
    }


    @Test
    @DisplayName("Should return random joke always- positive")
    void getRandomJokeTest() {
        //when

        //then
        Assertions.assertNotNull(jokeService.getRandomJoke().map(Joke::getValue).orElseThrow());
    }
}