/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

public class MovieLoadDriver {
    
    public static void main(String[] args) {
        Movies movies = Movies.getInstance();
        ArrayList<Movie> movieList = movies.getMovies();
        
        for (Movie m : movieList) {
            String genre = m.getGenres()[0];
            System.out.printf("Title: %s\n Genre: %s\n Year: %d", m.getTitle(), 
                    genre, m.getYear());
            System.out.println("");
        }
    }
}
