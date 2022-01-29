package pl.sda.chuck.repository;

import pl.sda.chuck.dao.JokeEntity;

@FunctionalInterface
public interface JokesRepository {
    /**
     * Generic save method for joke for all implementations (mocked,h2)
     *
     * @param joke - joke entity after being properly mapped from dto
     */
    void save(JokeEntity joke);
}
