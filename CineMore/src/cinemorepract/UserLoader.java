/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserLoader {
    
    public static final String USER_FILE = "src/cinemorepract/Users.json";
    
    public static ArrayList<User> loadUsers() {
        ArrayList<User> userList = new ArrayList<>();
        
        try {
            File filename = new File(USER_FILE);
            FileReader reader = new FileReader(filename);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);
            
            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                String name = (String)userJSON.get("name");
                String email = (String)userJSON.get("email");
                String pass = (String)userJSON.get("password");
                String type = (String)userJSON.get("type");
                
                switch(type) {
                    case "Account Holder":
                        AccountHolder acctH = new AccountHolder(name, email, pass);
                        userList.add(acctH);
                        break;
                    case "Employee":
                        long empID = (long)userJSON.get("id");
                        Employee emp = new Employee(name, email, pass, empID);
                        userList.add(emp);
                        break;
                    case "Administrator":
                        Administrator admin = new Administrator(name, email, pass);
                        userList.add(admin);
                        break;
                    default:
                        break;
                }
            }
            return userList;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void addUser() {
        
    }
}
