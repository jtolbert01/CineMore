/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

public class Venues {
    public static Venues venues = null;
    public static ArrayList<Venue> venueList = new ArrayList<>();
    
    private Venues() {
        venueList = CoreVenues.loadVenues();
    }
    
    public static Venues getInstance() {
        if (venues == null) venues = new Venues();
        return venues;
    }
    
    public ArrayList<Venue> getVenues() {
        return venueList;
    }
    
}
