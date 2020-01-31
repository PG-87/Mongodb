import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import org.bson.Document;


import java.io.FileNotFoundException;
import java.util.List;


public class Program {
    public static void main(String[] args) throws FileNotFoundException {

        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("javatest");
        database.createCollection("coll");
        MongoCollection<Document> collection = database.getCollection("coll");
        OrgJsonMain json = new OrgJsonMain();
        List<Document> docs = json.parseAndReturn("C:\\Users\\pgpat\\IdeaProjects\\Mongodb\\docs.json");
        collection.insertMany(docs);

        client.close();
    }
}
