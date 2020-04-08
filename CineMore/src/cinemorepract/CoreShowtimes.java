
package cinemorepract;
import java.util.*;

//This class populates all Movies with some default showtimes for testing
public class CoreShowtimes {
    
    public static final String[] times = {"12:00", "1:00", "1:15", "2:45", "3:30",
                                          "4:30", "6:00", "7:30", "9:00", "10:30"};
    
    public static void loadShowtimes() {
        Random rand = new Random();
        Movies movies = Movies.getInstance();
        ArrayList<Movie> mList = movies.getMovies();
        Plays plays = Plays.getInstance();
        ArrayList<Play> pList = plays.getPlays();
        Concerts concerts = Concerts.getInstance();
        ArrayList<Concert> cList = concerts.getConcerts();
        Venues venues = Venues.getInstance();
        ArrayList<Venue> movieT = new ArrayList<>();
        ArrayList<Venue> vList = venues.getVenues();
        for(int i = 0; i < vList.size(); i++) {
            if (vList.get(i).getType().equals("Movie Theater")) {
                movieT.add(vList.get(i));
                vList.remove(vList.get(i));
            }
        }
        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < mList.size(); i++) {
                int vChoice = rand.nextInt(vList.size() - 1);
                int tChoice = rand.nextInt(times.length - 1);
                Venue tempV = vList.get(vChoice);
                String tempT = times[tChoice];
                mList.get(i).setShowing(tempV, tempT);
            }
        }
        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < pList.size(); i++) {
                int vChoice = rand.nextInt(vList.size() - 1);
                int tChoice = rand.nextInt(times.length - 1);
                Venue tempV = vList.get(vChoice);
                String tempT = times[tChoice];
                pList.get(i).setShowing(tempV, tempT);
            } 
        }
        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < cList.size(); i++) {
                int vChoice = rand.nextInt(vList.size() - 1);
                int tChoice = rand.nextInt(times.length - 1);
                Venue tempV = vList.get(vChoice);
                String tempT = times[tChoice];
                cList.get(i).setShowing(tempV, tempT);
            } 
        }
    }
}
