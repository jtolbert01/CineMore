/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

//This class instantiates a couple theaters for testing
public class CoreVenues {
    
    
    MovieTheater theater1;
    MovieTheater theater2;
    ArrayList<Venue> venues;
    int theater_num = 0;
    
    public CoreVenues() {
        setMovieTheater(theater1, "Cinema18", "555-555-5555", 7);
        setMovieTheater(theater2, "Regal IMAX", "555-555-5551", 10);
        venues = new ArrayList<>();
    }
    
    public void setMovieTheater(MovieTheater mT, String name, String contact, 
                                int max) {
        mT = new MovieTheater(name, contact, max);
        int xRows = 25;
        int yCols = 10;
        int[][] testMap = new int[xRows][yCols];
        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < yCols; j++) {
                testMap[i][j] = 0;
            }
        }
        mT.addTheater(1, 250, testMap);
        venues.add(mT);
    }
    
    public ArrayList<Venue> getVenues() {
        return venues;
    }

}