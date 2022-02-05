package pl.sda.chuck.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.Joke;

@Mapper
public interface JokeMapper {
    JokeMapper INSTANCE = Mappers.getMapper(JokeMapper.class);

    Joke jokeEntityToJoke(JokeEntity jokeEntity);
}
