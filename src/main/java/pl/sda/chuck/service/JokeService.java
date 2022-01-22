package pl.sda.chuck.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.chuck.dto.Joke;

import java.util.Optional;

@Service
@Slf4j //Will generate code private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JokeService.class)
public class JokeService {

    RestTemplate restTemplate = new RestTemplate();

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
}
