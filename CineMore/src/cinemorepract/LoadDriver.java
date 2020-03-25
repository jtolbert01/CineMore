/*
 * Joshua S Tolbert
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
            System.out.printf("Title: %s\n Year: %d\n Genres: ", m.getTitle(), 
                    m.getYear());
            for(int i = 0; i < m.getGenres().length; i++) {
                if (i == m.getGenres().length - 1) {
                    System.out.print(m.getGenres()[i]);
                }
                else {
                    System.out.print(m.getGenres()[i] + ", ");
                }
            }
            System.out.println("");
        }
        
        //Load plays from JSON and Print Information
        System.out.println("****PLAYS****");
        Plays plays = Plays.getInstance();
        ArrayList<Play> playList = plays.getPlays();
        for (Play p : playList) {
            System.out.printf("Title: %s\n Author: %s\n Year: %d\n Characters: ",
                     p.getTitle(), p.getAuthor(), p.getYear());
            for(int i = 0; i < p.getCharacters().length; i++) {
                if (i == p.getCharacters().length - 1) {
                System.out.print(p.getCharacters()[i]);
                }
                else {
                    System.out.print(p.getCharacters()[i] + ", ");
                }
            }
            System.out.println("");
        }
    }
}
