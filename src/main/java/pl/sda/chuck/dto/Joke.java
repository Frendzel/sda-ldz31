package pl.sda.chuck.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;

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
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Joke implements Serializable {
    String type;
    @Valid
    JokeValue value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JokeValue getValue() {
        return value;
    }

    public void setValue(JokeValue value) {
        this.value = value;
    }
}
