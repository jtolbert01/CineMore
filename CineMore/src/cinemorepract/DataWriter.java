/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter {
    
    public static final String USER_FILE = "src/cinemorepract/Users.json";
    
    public static void saveAccount(JSONObject acct) {
        
        try {
            FileReader reader = new FileReader(USER_FILE);
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject)parser.parse(reader);
	    JSONArray usersJSON = (JSONArray)jsonData.get("users");
            
            usersJSON.add(acct);
            
            FileWriter file = new FileWriter(USER_FILE);
            file.write(usersJSON.toJSONString());
            file.flush();
            file.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
