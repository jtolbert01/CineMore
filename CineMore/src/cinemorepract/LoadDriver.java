/*
* Jacob A Carter & Joshua S Tolbert
*/

package cinemorepract;
import java.util.ArrayList;

//Current version of Driver
/*
*Latest Update: Driver to load Movies and Plays
*/
public class LoadDriver {
    
    public static void main(String[] args) {
        //Load movies from JSON and Print Information
        Movies movies = Movies.getInstance();
        ArrayList<Movie> movieList = movies.getMovies();
        System.out.println("****MOVIES****");
        for (Movie m : movieList) {
            System.out.print(m.toString());
            System.out.println("");
        }
        
        //Load plays from JSON and Print Information
        System.out.println("****PLAYS****");
        Plays plays = Plays.getInstance();
        ArrayList<Play> playList = plays.getPlays();
        for (Play p : playList) {
            System.out.print(p.toString());
            System.out.println("");
        }
        
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
