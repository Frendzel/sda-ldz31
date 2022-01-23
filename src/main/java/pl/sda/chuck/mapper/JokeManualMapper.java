package pl.sda.chuck.mapper;

import lombok.NoArgsConstructor;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.exception.ExternalTechnicalException;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE) //Used in utility classes to avoid redundant creations
public class JokeManualMapper {

    public static JokeEntity map(Joke joke) {
        JokeEntity jokeEntity = new JokeEntity();
        if (joke != null && joke.getValue() != null) { //Optional
            jokeEntity.setJoke(joke.getValue().getJoke());
            jokeEntity.setCategories(joke.getValue().getCategories());
            jokeEntity.setExternalId(joke.getValue().getId());
        } else {
            throw new ExternalTechnicalException("Wrong Joke construction");
        }
        //TODO ID has not been set, should be automatically generated
        return jokeEntity;
    }

    public static JokeEntity map(Optional<Joke> joke) {
        JokeEntity jokeEntity = new JokeEntity();
        return joke.map(Joke::getValue)
                .map(jokeValue -> {
                    jokeEntity.setJoke(jokeValue.getJoke());
                    jokeEntity.setCategories(jokeValue.getCategories());
                    jokeEntity.setExternalId(jokeValue.getId());
                    return jokeEntity;
                }).orElseThrow(() -> new ExternalTechnicalException("Wrong Joke construction"));
    }
}
