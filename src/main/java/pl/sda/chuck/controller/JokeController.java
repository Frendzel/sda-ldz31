package pl.sda.chuck.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sda.chuck.dao.BaseResponse;
import pl.sda.chuck.dao.RESPONSE_STATUS;
import pl.sda.chuck.dto.CountResponse;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.exception.ExternalTechnicalException;
import pl.sda.chuck.service.JokeService;

import javax.validation.Valid;

@RestController
@Slf4j
@Validated
public class JokeController {

    @Autowired
    JokeService jokeService;

    @GetMapping("/jokes/random")
    public Joke getRandomJoke() {
        return jokeService.getRandomJoke().orElseThrow(() -> new ExternalTechnicalException("oh nein!"));
        //TODO implement proper error handling and diff exceptions
    }

    @GetMapping("/jokes/count")
    public CountResponse getJokesCount() {
        return jokeService.countJokes().orElseThrow(() -> new ExternalTechnicalException("oh nein!"));
    }

    @GetMapping("/joke/{id}")
    public Joke getJoke(@PathVariable Integer id) {
        log.info("Get joke with id: {}", id);
        return jokeService.getJoke(id).orElseThrow(() -> new ExternalTechnicalException("oh nein!"));
    }

    @PostMapping("/joke/add")
    @Valid
    public BaseResponse saveJoke(@RequestBody @Valid Joke joke) {
        log.info("Joke to be saved: {}", joke);
        jokeService.save(joke);
        return new BaseResponse(RESPONSE_STATUS.SUCCESS);
    }

    @GetMapping("/joke/internal/{externalId}")
    public Joke getJokeInternal(@PathVariable Integer externalId) {
        log.info("Get joke with id: {}", externalId);
        return jokeService.getJokeFromDb(externalId);
    }
}
