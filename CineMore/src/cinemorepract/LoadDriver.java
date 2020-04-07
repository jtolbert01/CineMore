/*
* Jacob A Carter & Joshua S Tolbert
*/

package cinemorepract;
import java.util.ArrayList;
import java.util.Scanner;

//Current version of Driver
/*
*Latest Update: Driver to load Movies and Plays
*/
public class LoadDriver {
    
    public static void displayMovies() {
        //Load movies from JSON and Print Information
        Movies movies = Movies.getInstance();
        ArrayList<Movie> movieList = movies.getMovies();
        int currentMovie = 1;
        System.out.println("****MOVIES****");
        for (Movie m : movieList) {
            System.out.print(currentMovie  + ").  \n" + m.toString());
            System.out.println("");
            ++currentMovie;
        }
    }
        
    public static void displayPlays() {
        //Load plays from JSON and Print Information
        System.out.println("****PLAYS****");
        Plays plays = Plays.getInstance();
        int currentPlay = 1;
        ArrayList<Play> playList = plays.getPlays();
        for (Play p : playList) {
            System.out.print(currentPlay  + ").  \n" + p.toString());
            System.out.println("");
            ++currentPlay;
        }
    }
        
    public static void displayConcerts() {
        //Load concerts from JSON and Print Information
        Concerts concerts = Concerts.getInstance();
        int currentConcert = 1;
        ArrayList<Concert> concertList = concerts.getConcerts();
        System.out.println("****CONCERTS****");
        for (Concert c : concertList) {
            System.out.print(currentConcert  + ").  \n" + c.toString());
            System.out.println("");
            ++currentConcert;
        }
    }
}
