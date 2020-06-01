package com.accenture.technologylearningpills.reactivebackend;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableReactiveMongoRepositories
@ComponentScan(basePackages = "com.accenture.technologylearningpills.reactivebackend")
public class ReactiveBackendApplication extends AbstractReactiveMongoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveBackendApplication.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return "reactive";
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("Pon aquí la URL de tu base de datos mongodb en formato mongodb+srv");
    }
}
