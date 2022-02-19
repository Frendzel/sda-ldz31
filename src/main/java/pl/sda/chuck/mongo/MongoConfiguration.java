package pl.sda.chuck.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration //https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
@EnableMongoRepositories
@Profile("mongo")
public class MongoConfiguration {

    @Value("${mongo.address}")
    private String address;

    @Value("${mongo.user}")
    private String user;

    @Value("${mongo.password}")
    private String password;

    @Value("${mongo.database}")
    private String databaseName;

    /*
     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
     */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://" + user + ":" + password + "@" +
                address + "?retryWrites=true&w=majority");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, databaseName);
    }

}