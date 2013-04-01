package com.demoapp.demo.util.mongodb;

/**
 * Date: 3/31/13
 * Time: 11:30 PM
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MongoBroker {
    private static MongoTemplate mongoTemplate;
    private static MongoBroker mongoBroker = new MongoBroker();

    public static MongoBroker getInstance() {
        return mongoBroker;
    }

    // TODO: Throw a more specific exception
    public MongoTemplate getTemplate() throws Exception {
        if(mongoTemplate == null) {
            final SimpleMongoDbFactory mongoDBFactory = getMongoDBFactory();
            mongoTemplate = new MongoTemplate(mongoDBFactory);
        }
        return mongoTemplate;
    }

    // TODO: Throw a more specific exception
    private SimpleMongoDbFactory getMongoDBFactory() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final String mongoConfigFileName = "src/main/resources/mongodb/mongo-config.json";

        try {
            MongoConfig mongoConfig = mapper.readValue(new File(mongoConfigFileName), MongoConfig.class);
            System.out.println(mongoConfig.toString());

            final UserCredentials userCredentials = new UserCredentials(mongoConfig.getUsername(), mongoConfig.getPassword());
            final MongoClient mongoClient = new MongoClient(mongoConfig.getHostname(), mongoConfig.getPort());
            System.out.println("MongoDB version [" + mongoClient.getVersion() + "]");
            mongoClient.setReadPreference(ReadPreference.secondary());
            return new SimpleMongoDbFactory(mongoClient, mongoConfig.getDatabase(), userCredentials);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw exception;
        }
    }
}