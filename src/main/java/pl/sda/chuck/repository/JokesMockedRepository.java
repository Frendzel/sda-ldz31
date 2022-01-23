package pl.sda.chuck.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dao.JokesMockedDb;

@Slf4j
public class JokesMockedRepository implements JokesRepository {

    private JokesMockedDb jokesMockedDb;

    public JokesMockedRepository(JokesMockedDb jokesMockedDb) {
        this.jokesMockedDb = jokesMockedDb;
    }

    public void save(JokeEntity joke) {
        log.debug("Before saving joke: {}", joke); //The same as log.debug("Before saving joke: " + joke);
        jokesMockedDb.getJokes().add(joke);
        log.debug("After saving joke: {}", joke);
    }
}
