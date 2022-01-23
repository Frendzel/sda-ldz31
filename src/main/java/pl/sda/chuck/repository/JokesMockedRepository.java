package pl.sda.chuck.repository;


import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dao.JokesMockedDb;

public class JokesMockedRepository implements JokesRepository {

    private JokesMockedDb jokesMockedDb;

    public JokesMockedRepository(JokesMockedDb jokesMockedDb) {
        this.jokesMockedDb = jokesMockedDb;
    }

    public void save(JokeEntity joke) {
        jokesMockedDb.getJokes().add(joke);
    }
}
