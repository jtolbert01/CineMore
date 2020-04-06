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

public class Employee extends User {
    private long employeeID;
    public static final String type = "Employee";
    
    public Employee(String name, String email, String pass, long empID) {
        setName(name);
        setEmail(email);
        setPassword(pass);
        setEmployeeID(empID);
        setType(this.type);
    }
    
    public void setEmployeeID(long empID) {
        this.employeeID = empID;
    }
    
    public long getEmployeeID() {
        return this.employeeID;
    }
    
    public JSONObject toJSON() {
        JSONObject employee = new JSONObject();
        employee.put("name", getName());
        employee.put("id", getEmployeeID());
        employee.put("email", getEmail());
        employee.put("password", getPassword());
        employee.put("type", type);
        
        return employee;
    }
    
    @Override
    public String toString() {
        return "Name: " + getName() + "\nAccount Type: " + getType();
    }
}
