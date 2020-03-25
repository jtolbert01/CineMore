/*
* Jacob A Carter & Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

//Create instance of Movies to load
public class Movies {
    public static Movies movies = null;
    public static ArrayList<Movie> movieList = new ArrayList<>();
    
    private Movies() {
        this.movieList = MovieLoader.loadMovies();
    }
    
    public static Movies getInstance() {
        if(movies == null) movies = new Movies();
		
	return movies;
    }
    
    public ArrayList<Movie> getMovies() {
        return this.movieList;
    }

}
