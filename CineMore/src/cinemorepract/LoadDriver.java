/*
* Jacob A Carter & Joshua S Tolbert
*/

package cinemorepract;
import java.util.ArrayList;


public class LoadDriver {
    
    public static void displayMovies() {
        //Load movies from JSON and Print Information
        Movies movies = Movies.getInstance();
        ArrayList<Movie> movieList = movies.getMovies();
        System.out.println("****MOVIES****");
        for (Movie m : movieList) {
            System.out.print(m.toString());
            System.out.println("");
        }
    }
    
    public static void displayPlays() {
        //Load plays from JSON and Print Information
        System.out.println("****PLAYS****");
        Plays plays = Plays.getInstance();
        ArrayList<Play> playList = plays.getPlays();
        for (Play p : playList) {
            System.out.print(p.toString());
            System.out.println("");
        }
    }
    
    public static void displayConcerts() {
        //Load concerts from JSON and Print Information
        Concerts concerts = Concerts.getInstance();
        ArrayList<Concert> concertList = concerts.getConcerts();
        System.out.println("****CONCERTS****");
        for (Concert c : concertList) {
            System.out.print(c.toString());
            System.out.println("");
        }
    }
    
}
