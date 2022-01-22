package pl.sda.chuck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.chuck.dto.Joke;

import java.util.Optional;

@Service
public class JokeService {

    @Autowired
    RestTemplate restTemplate;

    public Optional<Joke> getRandomJoke() {
        try {
            ResponseEntity<Joke> response = restTemplate.getForEntity("http://api.icndb.com/jokes/random", Joke.class);
            return Optional.of(response)
                    .map(HttpEntity::getBody);
        } catch (Exception e) {
            //log
            //TODO handle exceptions
        }
        return Optional.empty();
    }
}
