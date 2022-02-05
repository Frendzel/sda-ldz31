package pl.sda.chuck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.chuck.dao.JokeEntity;

@Repository
public interface JokesH2Repository extends CrudRepository<JokeEntity, Integer> {

    //@Query("") alternative way to get data
    JokeEntity findByExternalId(Integer externalId); //get data via spring data mechanism
}