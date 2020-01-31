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
        database.createCollection("coll4");
        MongoCollection<Document> collection = database.getCollection("coll4");
        OrgJsonMain json = new OrgJsonMain();
        List<Document> docs = json.parseAndReturn();
        collection.insertMany(docs);

        client.close();
    }
}
