/*
 * Joshua S Tolbert
 */

package cinemorepract;
import org.json.simple.JSONObject;

public class AccountHolder extends User{
    public static final String type = "Account Holder";
    
    public AccountHolder(String name, String email, String pass) {
        setName(name);
        setEmail(email);
        setPassword(pass);
        setType(this.type);
    }
    
    public JSONObject toJSON() {
        JSONObject user = new JSONObject();
        user.put("name", getName());
        user.put("email", getEmail());
        user.put("password", getPassword());
        user.put("type", type);
        
        return user;
    }
    
    @Override
    public String toString() {
        return "Name: " + getName() + "\nAccount Type: " + getType();
    }
}
