package pl.sda.chuck.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
public class MongoConfiguration {

    @Value("${mongo.address}")
    private String address;

    @Value("${mongo.user}")
    private String user;

    @Value("${mongo.password}")
    private String password;

    /*
     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
     */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://" + user + ":" + password + "@" +
                address + "?retryWrites=true&w=majority");
    }

}