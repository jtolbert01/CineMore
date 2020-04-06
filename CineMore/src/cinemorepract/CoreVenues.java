/*
 * Joshua S Tolbert
 */

package cinemorepract;

//This class instantiates a couple theaters for testing
public class CoreVenues {
    MovieTheater theater1;
    MovieTheater theater2;
    
    public CoreVenues() {
        setMovieTheater(theater1, "Cinema18", "555-555-5555", 7);
        setMovieTheater(theater2, "Regal IMAX", "555-555-5551", 10);
    }
    
    public void setMovieTheater(MovieTheater mT, String name, String contact, 
                                int max) {
        mT = new MovieTheater(name, contact, max);
        
    }
}
