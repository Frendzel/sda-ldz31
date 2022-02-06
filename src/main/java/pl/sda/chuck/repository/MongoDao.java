package pl.sda.chuck.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import pl.sda.chuck.dao.JokeEntity;

@Component
@Slf4j
public class MongoDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public void save(JokeEntity entity) {
        log.info("DB Name: " + mongoTemplate.getDb().getName());
        mongoTemplate.save(entity);
    }


}
