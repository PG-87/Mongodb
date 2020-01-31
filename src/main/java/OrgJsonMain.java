import org.json.JSONException;
import java.io.*;
import org.json.*;

public class OrgJsonMain {


    public static void main(String[] args) {

        try{
            String json = getJsonAsString("C:\\Users\\pgpat\\IdeaProjects\\Mongodb\\docs.json");
            JSONTokener jt = new JSONTokener(json);
            JSONObject jo = new JSONObject(jt);
            JSONArray jArr = jo.getJSONArray("document");

            for (int i = 0; i < jArr.length() ; i++) {
                jo = jArr.getJSONObject(i);
                System.out.println("Resutrant: " + jo.getString("name"));
                System.out.println("Stars: " + jo.getInt("stars"));
                System.out.println("Food: " + jo.getString("categories"));
            }
        }catch(IOException ioe){
            System.err.println("Couldn't read file: " + ioe.getMessage());
        }catch (JSONException jsone){
            System.err.println("Couldn´t parse JSON: " + jsone.getMessage());
        }

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
