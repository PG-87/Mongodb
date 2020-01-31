import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {

        List<Document> savedList = new ArrayList<Document>();
        jsonParser jPars = new jsonParser();

        //jPars.parseAndPrint("C:\\Users\\pgpat\\IdeaProjects\\Mongodb\\docs.json");
        //jPars.parseAndSave("C:\\Users\\pgpat\\IdeaProjects\\Mongodb\\docs.json");
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("javatest");
        database.createCollection("coll2");
        MongoCollection<Document> collection = database.getCollection("coll2");


        savedList.add((Document) jPars.parseAndSave("C:\\Users\\pgpat\\IdeaProjects\\Mongodb\\docs.json"));
        Document doc = new Document("_id", 2)
                .append("String", "hihi");
        collection.insertOne(doc);




        collection.find().forEach(printBlock);
        client.close();
    }
}
