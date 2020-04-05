/*
 * Joshua S Tolbert
 */

package cinemorepract;


public abstract class User {
    private String name;
    private String email;
    private String password;
    private String userType;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String pass) {
        this.password = pass;
    }
    
    public void setType(String type) {
        this.userType = type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getType() {
        return this.userType;
    }
}
