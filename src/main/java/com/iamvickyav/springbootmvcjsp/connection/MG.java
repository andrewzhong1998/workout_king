package com.iamvickyav.springbootmvcjsp.connection;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MG {
    public static MongoDatabase getDB(){
        MongoDatabase db = null;
        try {
            MongoClient client = new MongoClient(new MongoClientURI("mongodb://workout_king:comp426@3.136.74.106:27017"));
            db = client.getDatabase("workout_king");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return db;
    }

    public static MongoCollection<Document> getCollection(String name){
        MongoDatabase db = MG.getDB();
        MongoCollection<Document> coll = db.getCollection(name);
        return coll;
    }
    public static void main(String[] args){
        MongoDatabase db = MG.getDB();
        MongoCollection<Document> coll = db.getCollection("intakes");
        Document doc1 = new Document("name", "Amarcord Pizzeria")
                .append("contact", new Document("phone", "264-555-0193")
                        .append("email", "amarcord.pizzeria@example.net")
                        .append("location", Arrays.asList(-73.88502, 40.749556)))
                .append("stars", 2)
                .append("categories", Arrays.asList("Pizzeria", "Italian", "Pasta"));

        //doc1.put

        Document doc2 = new Document("name", "Blue Coffee Bar")
                .append("contact", new Document("phone", "604-555-0102")
                        .append("email", "bluecoffeebar@example.com")
                        .append("location",Arrays.asList(-73.97902, 40.8479556)))
                .append("stars", 5)
                .append("categories", Arrays.asList("Coffee", "Pastries"));
        List<Document> documents = new ArrayList<Document>();
        documents.add(doc1);
        documents.add(doc2);

        coll.insertMany(documents);
        //for (String name : db.listCollectionNames()) {
        //    System.out.println(name);
        //}
    }
}
