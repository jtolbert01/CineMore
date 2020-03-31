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
    
    public static void main(String[] args) {
    	Scanner key = new Scanner(System.in);
        //Load movies from JSON and Print Information
        Movies movies = Movies.getInstance();
        ArrayList<Movie> movieList = movies.getMovies();
        System.out.println("****MOVIES****");
        for (Movie m : movieList) {
            System.out.print(m.toString());
            System.out.println("");
        }
        System.out.println("What type of search would you like to perform? Enter the corresponding number: ");
        System.out.println("1. Title");
        System.out.println("2. Year");
        System.out.println("3. Genre");
        System.out.println("4. Cast");
        System.out.println("5. Rating (Will look for any movies rated at least this good, 1 - 10)" );
        System.out.println("6. Runtime (Will look for any movies with a runtime less than x)");
        System.out.println("7. MPAA (G, PG, PG-13, R)");
        
        
        int searchType = key.nextInt();
        key.nextLine();
        
        System.out.println("Please enter you are searching for: ");
        String searchTarget = key.nextLine();
        
        ArrayList<Movie> searchMovie = Search.returnMovie(movieList, searchTarget, searchType);
        if (searchMovie.size() != 0) {
	        for(Movie m : searchMovie) {
	        	System.out.println(m.toString());
	        	System.out.println(" ");
	        }
        } else {
        	System.out.println("Movie not found");
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
