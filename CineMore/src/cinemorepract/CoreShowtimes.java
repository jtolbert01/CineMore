
package cinemorepract;
import java.util.*;

//This class populates all Movies with some default showtimes for testing
public class CoreShowtimes {
    
    public static final String[] times = {"12:00", "1:00", "1:15", "2:45", "3:30",
                                          "4:30", "6:00", "7:30", "9:00", "10:30"};
    
    public static void loadShowtimes() {
        Random rand = new Random();
        Movies movies = Movies.getInstance();
        ArrayList<Movie> list = movies.getMovies();
        Venues venues = Venues.getInstance();
        ArrayList<Venue> vList = venues.getVenues();
        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < list.size(); i++) {
                int vChoice = rand.nextInt(vList.size() - 1);
                int tChoice = rand.nextInt(times.length - 1);
                Venue tempV = vList.get(vChoice);
                String tempT = times[tChoice];
                list.get(i).setShowing(tempV, tempT);
            }
        }
    }
}
