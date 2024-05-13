package org.cuby;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("cubyDB");

        mongoClient.listDatabaseNames().forEach(System.out::println);

        database.createCollection("books");

        MongoCollection<Document> collection = database.getCollection("books");
    }
}