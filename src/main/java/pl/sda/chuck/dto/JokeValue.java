package pl.sda.chuck.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Sample joke below taken from: http://api.icndb.com/jokes/random
 * <p>
 * Inner class for joke: {@link Joke}
 * {
 * "type": "success",
 * "value": {
 * "id": 145,
 * "joke": "Chuck Norris is currently suing myspace for taking the name of what he calls everything around you.",
 * "categories": []
 * }
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JokeValue {
    Integer id;
    String joke;
    List<String> categories;
}
