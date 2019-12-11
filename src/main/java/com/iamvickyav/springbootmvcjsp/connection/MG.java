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
            MongoClient client = new MongoClient(new MongoClientURI(""));
            db = client.getDatabase("");
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
}
