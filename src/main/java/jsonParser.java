import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static javax.json.JsonValue.ValueType.OBJECT;

public class jsonParser {

    private List<cafes> cafes;

    public void parseAndPrint(String localPath) throws FileNotFoundException {

        try {
            JsonReader reader = Json.createReader(new FileReader(localPath));
            JsonStructure jsonStruct = reader.read();

            if (jsonStruct.getValueType().equals(JsonValue.ValueType.OBJECT)) {

                System.out.println("Casting to JsonObject...");
                JsonObject jo = (JsonObject) jsonStruct;
                JsonArray docs = jo.getJsonArray("document");

                for (int i = 0; i < docs.size(); i++) {
                    System.out.println("_id: " + docs.getJsonObject(i).getString("_id", "no id"));
                    System.out.println("name: " + docs.getJsonObject(i).getString("name", "no name"));
                    System.out.println("stars: " + docs.getJsonObject(i).getInt("stars", 0));

                    JsonArray arr = docs.getJsonObject(i).getJsonArray("categories");
                    System.out.print("Categories: [");

                    for (int j = 0; j < arr.size(); j++) {
                        System.out.print(arr.getString(j));
                        System.out.print(", ");
                    }
                    System.out.print("]");
                    System.out.println(" ");
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("jsonFile");
        }
    }

    public List parseAndSave(String localPath) throws FileNotFoundException {
        try {
            JsonReader reader = Json.createReader(new FileReader(localPath));
            JsonStructure jsonStruct = reader.read();

            if (jsonStruct.getValueType().equals(OBJECT)) {

                JsonObject jo = (JsonObject) jsonStruct;
                JsonArray doc = jo.getJsonArray("document");

                for (int i = 0; i < doc.size(); i++) {

                    String id = doc.getJsonObject(i).getString("_id", "no id");
                    String name = doc.getJsonObject(i).getString("name", "no name");
                    int stars = doc.getJsonObject(i).getInt("stars");

                    cafes newCafe = new cafes(id, name, stars);

                    JsonArray arr = doc.getJsonObject(i).getJsonArray("categories");
                    for (int k = 0; k < arr.size(); k++) {
                        newCafe.addToCategories(arr.getString(k));
                    }
                    cafes.add(newCafe);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("jsonFile");
        }
        return cafes;
    }

//    public void parseAndSaveJsonArray(String localPath) throws FileNotFoundException {
//        try {
//            JsonReader reader = Json.createReader(new FileReader(localPath));
//            JsonStructure jsonStruct = reader.read();
//
//            if (jsonStruct.getValueType().equals(OBJECT)){
//                JSONObject jo = (JSONObject) jsonStruct;
//                JSONArray doc = jo.getJSONArray("document");
//
//                for (int i = 0; i < doc.size() ; i++) {
//                    doc.
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            throw new FileNotFoundException("jsonFile");
//        }
//    }
}
