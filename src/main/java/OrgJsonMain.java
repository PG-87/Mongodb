import org.bson.Document;
import org.json.JSONException;
import java.io.*;
import java.util.*;


import org.json.*;

public class OrgJsonMain {

        public List parseAndReturn(String localPath){

        List<Document> docs = new ArrayList<Document>();

        try{
            String json = getJsonAsString(localPath);
            JSONTokener jt = new JSONTokener(json);
            JSONObject jo = new JSONObject(jt);
            JSONArray jArr = jo.getJSONArray("document");

            for (int i = 0; i < jArr.length(); i++) {
                jo = jArr.getJSONObject(i);
                Document doc = new Document("_id", jo.getString("_id"))
                        .append("Name", jo.getString("name"))
                        .append("stars", jo.getInt("stars"))
                        .append("categories", jo.getString("categories"));
                docs.add(doc);
            }

        }catch(IOException ioe){
            System.err.println("Couldn't read file: " + ioe.getMessage());
        }catch (JSONException jsone){
            System.err.println("Couldn´t parse JSON: " + jsone.getMessage());
        }
        return docs;
    }
    private static String getJsonAsString(String file) throws IOException{
        StringBuilder sb = new StringBuilder();
        String ls = System.getProperty("line.separator");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while((line = reader.readLine()) !=null){
            sb.append(line);
            sb.append(ls);
        }

        reader.close();
        return sb.toString();
    }
}
