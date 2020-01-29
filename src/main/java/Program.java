import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {

        List<Document> documents = new ArrayList<Document>();
        Document document = new Document("_id", "5c39f9b5df831369c19b6bca")
                .append("name", "Sun Bakery Trattoria")
                .append("stars", 4)
                .append("categories", Arrays.asList("Pizza", "Pasta", "Italian", "Coffee", "Sandwiches"));
        documents.add(document);

        Document document2 = new Document("_id", "5c39f9b5df831369c19b6bcb")
                .append("name", "Blue Bagels Grill")
                .append("stars", 3)
                .append("categories", Arrays.asList("Bagels", "Cookies", "Sandwiches"));
        documents.add(document2);

        Document document3 = new Document("_id", "5c39f9b5df831369c19b6bcc")
                .append("name", "Hot Bakery Cafe")
                .append("stars", 4)
                .append("categories", Arrays.asList("Bakery", "Cafe", "Coffee", "Dessert"));
        documents.add(document3);

        Document document4 = new Document("_id", "5c39f9b5df831369c19b6bcd")
                .append("name", "XYZ Coffee Bar")
                .append("stars", 5)
                .append("categories", Arrays.asList("Coffee", "Cafe", "Bakery", "Chocolates"));
        documents.add(document4);

        Document document5 = new Document("_id", "5c39f9b5df831369c19b6bce")
                .append("name", "456 Cookies Shop")
                .append("stars", 4)
                .append("categories", Arrays.asList("Bakery", "Cookies", "Cake", "Coffee"));
        documents.add(document5);


        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("javatest");
        database.createCollection("coll");
        Document doc = new Document("_id", 1);


        client.close();
    }
}
