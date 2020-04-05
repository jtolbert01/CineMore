/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Administrator extends User {
    public static final String type = "Administrator";
    
    public Administrator(String name, String email, String pass) {
        setName(name);
        setEmail(email);
        setPassword(pass);
        setType(this.type);
    }
    
    @Override
    public String toString() {
        return "Name: " + getName() + "\nAccount Type: " + getType();
    }
}
