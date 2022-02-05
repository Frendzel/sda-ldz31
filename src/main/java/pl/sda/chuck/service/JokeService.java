package pl.sda.chuck.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.chuck.aspect.CalculateInvocationTime;
import pl.sda.chuck.aspect.LogMe;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.CountResponse;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.repository.JokesH2Repository;
import pl.sda.chuck.repository.JokesRepository;

import java.util.List;
import java.util.Optional;

import static pl.sda.chuck.mapper.JokeManualMapper.map;
import static pl.sda.chuck.mapper.JokeMapper.INSTANCE;

@Service
@Slf4j
//Will generate code private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JokeService.class)
//TODO JokeService refactor -> 3 methods to one
public class JokeService {

    private final RestTemplate restTemplate = new RestTemplate(); //TOOO HttpClient

    @Autowired
    private JokesRepository repository;

    @Autowired
    private JokesH2Repository h2Repository;

    @CalculateInvocationTime
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

    @LogMe
    @CalculateInvocationTime
    public void save(Joke joke) {
        //Mapping between DTO and DAO
        //Invoke save method on repository
        repository.save(map(joke));
        h2Repository.save(map(joke));
    }

    @LogMe
    @CalculateInvocationTime
    public void saveAlternativeWay(Joke joke) {
        JokeEntity jokeEntity = INSTANCE.jokeToJokeEntity(joke);
        repository.save(jokeEntity);
    }

    public Joke getJokeFromDb(Integer externalId) {
        JokeEntity byExternalId = h2Repository.findByExternalId(externalId);
        return INSTANCE.jokeEntityToJoke(byExternalId);
    }

    public List<JokeEntity> findAllJokes() {
        return IterableUtils.toList(h2Repository.findAll());
    }
}
