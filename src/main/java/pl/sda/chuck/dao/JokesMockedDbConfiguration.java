package pl.sda.chuck.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.sda.chuck.repository.JokesMockedRepository;
import pl.sda.chuck.repository.JokesRepository;

import javax.annotation.PostConstruct;

@Configuration // will be loaded as first
@Profile("mocked-db")
@Slf4j
public class JokesMockedDbConfiguration {

    @PostConstruct
    public void log() {
        log.info("We're using mockedDb configuration");
    }

    @Bean
    JokesMockedDb jokesMockedDb() {
        return new JokesMockedDb();
    }

    @Bean
    JokesRepository jokesRepository(JokesMockedDb jokesMockedDb){
        return new JokesMockedRepository(jokesMockedDb);
    }
}
