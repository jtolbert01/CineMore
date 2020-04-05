/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

public class Users {
    public static Users users = null;
    public static ArrayList<User> userList = new ArrayList<>();
    
    private Users() {
        userList = UserLoader.loadUsers();
    }
    
    public static Users getInstance() {
        if (users == null) users = new Users();
        return users;
    }
    
    public ArrayList<User> getUsers() {
        return userList;
    }
}
