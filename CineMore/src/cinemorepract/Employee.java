/*
 * Joshua S Tolbert
 */

package cinemorepract;


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
    
    @Override
    public String toString() {
        return "Name: " + getName() + "\nAccount Type: " + getType();
    }
}
