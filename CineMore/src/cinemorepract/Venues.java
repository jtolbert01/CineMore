/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

public class Venues {
    public static Venues venues = null;
    public static ArrayList<Venue> venueList = new ArrayList<>();
    CoreVenues ven = new CoreVenues();
    
    private Venues() {
        venueList = ven.getVenues();
    }
    
    public static Venues getInstance() {
        if (venues == null) venues = new Venues();
        return venues;
    }
    
    public static ArrayList<Venue> getVenues() {
        return venueList;
    }
    
}
