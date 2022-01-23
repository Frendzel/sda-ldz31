package pl.sda.chuck.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JokeEntity {
    Integer id;
    Integer externalId;
    String joke;
    //TODO should be then moved to dedicated entity with many-to-many relationship
    List<String> categories;
}
