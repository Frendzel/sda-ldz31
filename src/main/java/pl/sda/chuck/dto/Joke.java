package pl.sda.chuck.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sample joke below taken from: http://api.icndb.com/jokes/random
 *
 * {
 * 	"type": "success",
 * 	"value": {
 * 		"id": 145,
 * 		"joke": "Chuck Norris is currently suing myspace for taking the name of what he calls everything around you.",
 * 		"categories": []
 *        }
 * }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Joke {
    String type;
    JokeValue value;
}
