package pl.sda.chuck.service;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.chuck.dto.CountResponse;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.exception.ExternalTechnicalException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class JokeServiceTest {

    public static final int SUT = 200;
    @Autowired
    JokeService jokeService;

    @Test
    @DisplayName("Should return 574 jokes asking for count - positive")
    void countJokes() {
        //when
        Optional<CountResponse> countResponse = jokeService.countJokes();
        //then
        assertEquals(574, countResponse.map(CountResponse::getValue).orElseThrow());
    }

    @Test
    @DisplayName("Should return random joke always- positive")
    void getRandomJokeTest() {
        //when
        Optional<Joke> randomJoke = jokeService.getRandomJoke();
        //then
        assertTrue(randomJoke.isPresent());
        assertNotNull(randomJoke.map(Joke::getValue).orElseThrow());
        assertNotNull(randomJoke.map(Joke::getType).orElseThrow());
    }

    @Test // Junit 5
//    @Test(expected = ExternalTechnicalException.class) --> Junit 4
    @DisplayName("Should return random joke always- positive")
    void getJokeWithIdTest() {
        //given
        String jokeToBeCompared = "{\"type\":\"success\",\"value\":{\"id\":200,\"joke\":\"On the set of Walker Texas Ranger Chuck Norris brought a dying lamb back to life by nuzzling it with his beard. As the onlookers gathered, the lamb sprang to life. Chuck Norris then roundhouse kicked it, killing it instantly. This was just to prove that the good Chuck givet\",\"categories\":[]}}";
        Gson gson = new Gson();
        //when
        Optional<Joke> joke = jokeService.getJoke(SUT);
        //then
        assertEquals(gson.fromJson(jokeToBeCompared, Joke.class), joke.orElseThrow(() -> new ExternalTechnicalException("nope")));
//        Assertions.assertThrows(ExternalTechnicalException.class, () -> jokeService.getJoke(SUT)); // how to test exceptions

//        //Below test could be used if we want to check that we won't have any exception coming from service layer.
//        try{
//            jokeService.getJoke(1);
//        } catch (Exception e){
//            fail();
//        }
//
//        //Below test could be used if we want to check that we will have any exception coming from service layer.
//        try{
//            jokeService.getJoke(9999);
//            fail();
//        } catch (Exception e){
//            //ok
//            //assertions
//        }
    }

}