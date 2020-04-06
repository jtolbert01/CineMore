/*
 * Joshua S Tolbert
 */

package cinemorepract;
import org.json.simple.JSONObject;

public class Administrator extends User {
    public static final String type = "Administrator";
    
    public Administrator(String name, String email, String pass) {
        setName(name);
        setEmail(email);
        setPassword(pass);
        setType(this.type);
    }
    
    public JSONObject toJSON() {
        JSONObject admin = new JSONObject();
        admin.put("name", getName());
        admin.put("email", getEmail());
        admin.put("password", getPassword());
        admin.put("type", type);
        
        return admin;
    }
    
    @Override
    public String toString() {
        return "Name: " + getName() + "\nAccount Type: " + getType();
    }
}
