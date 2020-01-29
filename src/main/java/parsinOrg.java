import org.json.*;

import java.io.File;

public class parsinOrg {
    File file = new File("C:/Users/pgpat/Documents/jsonorg.json");
/*    try{
        JSONTokener jt = new JSONTokener(sb.toString);
        JSONObject jo = null;
        try {
            jo = new JSONObject(jt);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        System.out.println("First name: " + jo.getString("firstName"));
        System.out.println("Last name: " + jo.getString("lastName"));
        System.out.println("Age: " + jo.getInt("age"));
        System.out.println("Street address: " + jo.getString("streetAddress"));
        System.out.println("City: " + jo.getString("city"));
        System.out.println("State: " + jo.getString("state"));
        System.out.println("Postal code: " + jo.getString("postalCode"));

        JSONArray arr = jo.getJSONArray("phoneNumbers");
        System.out.println("Phone Numbers: ");
        for (int i = 0; i <arr.length() ; i++) {
            jo = arr.getJSONObject(i);
            if(jo.has("Mobile") && !jo.isNull("Home")){
                System.out.println("Mobile: " + jo.get("Mobile"));
            }
            if(jo.has("Home") && !jo.isNull("Home")){
                System.out.println("Home: " + jo.get("Home"));
            }
        }
    }catch(JSONException e){
        System.err.println("Couldn´t parse: "+ e.getMessage());
    }*/
}