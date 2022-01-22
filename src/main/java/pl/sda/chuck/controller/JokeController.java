package pl.sda.chuck.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.chuck.dto.Joke;

@RestController
public class JokeController {

    //TODO remove when service will be ready
    Gson gson = new Gson();

    @GetMapping("/jokes/random")
    public Joke getRandomJoke() {
        //mock
        String jsonFirst = "{\n" +
                "\t\"type\":\"SUCCESS\",\n" +
                "\t\"value\":{\n" +
                "\t\t\"id\":145,\n" +
                "\t\t\"joke\":\"Chuck Norris is currently suing myspace for taking the name of what he calls everything around you.\",\n" +
                "\t\t\"categories\":[]\n" +
                "\t}\n" +
                "}";

        return gson.fromJson(jsonFirst, Joke.class);
    }
}
