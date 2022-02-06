package pl.sda.chuck.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
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
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JokeValue implements Serializable {
    @Digits(integer = 1000, fraction = 0)
    Integer id;
    @NotBlank
    String joke;
    List<String> categories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
