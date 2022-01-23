package pl.sda.chuck.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.chuck.dto.CountResponse;
import pl.sda.chuck.dto.Joke;

import java.util.Optional;

@Service
@Slf4j //Will generate code private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JokeService.class)
//TODO JokeService refactor -> 3 methods to one
public class JokeService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<Joke> getRandomJoke() {
        try {
            ResponseEntity<Joke> response = restTemplate.getForEntity("http://api.icndb.com/jokes/random", Joke.class);
            //log trace response
            log.trace("Response: {}", response);
            return Optional.of(response)
                    .map(HttpEntity::getBody);
        } catch (Exception e) {
            log.error("Unknown exception: {}", e.getMessage());
            //TODO handle exceptions properly (propagate exception + catch in GlobalExceptionHandler)
        }
        log.warn("Exception has not been propagated!");
        return Optional.empty();
    }

    public Optional<Joke> getJoke(Integer id) {
        try {
            ResponseEntity<Joke> response = restTemplate.getForEntity("http://api.icndb.com/jokes/{id}", Joke.class, id);
            //log trace response
            log.trace("Response: {}", response);
            return Optional.of(response)
                    .map(HttpEntity::getBody);
        } catch (Exception e) {
            log.error("Unknown exception: {}", e.getMessage());
            //TODO handle exceptions properly (propagate exception + catch in GlobalExceptionHandler)
        }
        log.warn("Exception has not been propagated!");
        return Optional.empty();
    }

    public Optional<CountResponse> countJokes() {
        try {
            ResponseEntity<CountResponse> response = restTemplate.getForEntity("http://api.icndb.com/jokes/count", CountResponse.class);
            //log trace response
            log.trace("Response: {}", response);
            return Optional.of(response)
                    .map(HttpEntity::getBody);
        } catch (Exception e) {
            log.error("Unknown exception: {}", e.getMessage());
            //TODO handle exceptions properly (propagate exception + catch in GlobalExceptionHandler)
        }
        log.warn("Exception has not been propagated!");
        return Optional.empty();
    }
}
