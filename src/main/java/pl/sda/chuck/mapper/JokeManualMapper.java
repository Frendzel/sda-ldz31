package pl.sda.chuck.mapper;

import lombok.NoArgsConstructor;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.Joke;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE) //Used in utility classes to avoid redundant creations
public class JokeManualMapper {

    public static JokeEntity map(Joke joke) {
        JokeEntity jokeEntity = new JokeEntity();
        jokeEntity.setJoke(joke.getValue().getJoke());
        jokeEntity.setCategories(joke.getValue().getCategories());
        jokeEntity.setExternalId(jokeEntity.getId());
        //TODO ID has not been set, should be automatically generated
        return jokeEntity;
    }
}
