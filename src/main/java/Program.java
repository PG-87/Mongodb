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

        OrgJsonMain json = new OrgJsonMain();
        CollectionCommands cc = new CollectionCommands();

        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("javatest");
        database.createCollection("coll2");
        MongoCollection<Document> collection = database.getCollection("coll2");

        List<Document> docs = json.parseAndReturn("C:\\Users\\pgpat\\IdeaProjects\\Mongodb\\docs.json");
        collection.insertMany(docs);

        System.out.println("\n" + "\n" + "Task2: Method for sys.out name on documents with category Cafe, " +
                " only show the name of cafe's");
        cc.printCafeFromCollection(collection);

        System.out.println("\n" + "\n" + "Task3: Metod that increment “stars” for the restaurant\n" +
                " with “name” = “XYZ Coffee Bar” with 1");
        cc.incrementStarsInCollection(collection);
        cc.printCollection(collection);

        System.out.println("\n" + "\n" + "Task4: Method that updats “name” for “456 Cookies Shop“ to “123 Cookies  Heaven” ");
        cc.editNameInCollection(collection);
        cc.printCollection(collection);

        System.out.println("\n" + "\n" + "Task5 Method aggragate restaurants with “stars” grater than 4 and print only  “name” and “stars” ");
        cc.aggregateInCollection(collection);
        client.close();
    }
}
