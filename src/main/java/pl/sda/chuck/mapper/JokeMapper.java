package pl.sda.chuck.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.chuck.dao.JokeEntity;
import pl.sda.chuck.dto.Joke;

@Mapper
public interface JokeMapper {
    JokeMapper INSTANCE = Mappers.getMapper(JokeMapper.class);

    @Mapping(source = "joke", target = "value.joke")
    @Mapping(source = "id", target = "value.id")
    Joke jokeEntityToJoke(JokeEntity jokeEntity);

    @Mapping(source = "value.joke", target = "joke")
    @Mapping(source = "value.id", target = "id")
    JokeEntity jokeToJokeEntity(Joke joke);
}
