import javax.json.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//Parsing using javax.json

public class JSONparser {
    private String jsonFile;
    public JSONparser(String jsonFile){
        this.jsonFile = jsonFile;
    }
    public void parseAndPrint()throws FileNotFoundException{
        try{
            JsonReader reader = Json.createReader(new FileReader(jsonFile));
            JsonStructure jsonStruct = reader.read();
            if(jsonStruct.getValueType().equals(JsonValue.ValueType.OBJECT)){
            System.out.println("Casting to JsonObject...");
            JsonObject jo = (JsonObject) jsonStruct;

            System.out.println("First name: " + jo.getString("firstName"));
            System.out.println("Last name: " + jo.getString("lastName"));
            System.out.println("Age: " + jo.getInt("age"));
            System.out.println("Street address: " + jo.getString("streetAddress", "No st. addr."));
            System.out.println("City: " + jo.getString("city", "No city"));
            System.out.println("State: " + jo.getString("state", "No state"));
            System.out.println("Postal code: " + jo.getString("postalCode", "No postal code"));

            JsonArray arr = jo.getJsonArray("phoneNumbers");
            System.out.println("Phone numbers:");
                for (JsonValue jv : arr){
                    if( ((JsonObject)jv).keySet().contains("Mobile")){
                        String mobile = ((JsonObject)jv).getString("Mobile");
                    if(mobile!=null){
                        System.out.println(" Mobile: " + mobile);
                    }
                }else if(((JsonObject)jv).keySet().contains("Home")){
                    String home = ((JsonObject)jv).getString("Home");
                    if(home!=null) {
                        System.out.println(" Home: " + home);
                    }
                }
                }
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
}
