package ninja.workout_king.app.connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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
}