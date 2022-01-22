package pl.sda.chuck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.exception.ExternalTechnicalException;
import pl.sda.chuck.service.JokeService;

@RestController
public class JokeController {

    @Autowired
    JokeService jokeService;

    @GetMapping("/jokes/random")
    public Joke getRandomJoke() {
        return jokeService.getRandomJoke().orElseThrow(() -> new ExternalTechnicalException("oh nein!"));
        //TODO implement proper error handling and diff exceptions
    }
}
