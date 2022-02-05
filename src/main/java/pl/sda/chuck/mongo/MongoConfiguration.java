package pl.sda.chuck.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
public class MongoConfiguration {

    /*
     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
     */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://<user>:<password>@cluster0.xlisg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    }

}