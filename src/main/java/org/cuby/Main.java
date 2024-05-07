package org.cuby;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("testMongoDB");

        mongoClient.listDatabaseNames().forEach(System.out::println);

        database.createCollection("customers");
        //database.listCollectionNames().forEach(System.out::println);
        
        MongoCollection<Document> collection = database.getCollection("customers");

        Document searchQuery = new Document();
        searchQuery.put("name", "Shubham");
        collection.deleteOne(searchQuery);

        Document document = new Document();
        ArrayList<String> listLang = new ArrayList<>();
        listLang.add("EN");
        listLang.add("RU");
        listLang.add("FR");

        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        document.put("lang", listLang);
        collection.insertOne(document);
    }
}