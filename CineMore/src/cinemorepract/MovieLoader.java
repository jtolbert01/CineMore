/*
 * Joshua S Tolbert
 */
package cinemorepract;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;


public class MovieLoader {

    public static final String MOVIE_FILE = "Movies.json";
    
    public static ArrayList<Movie> loadMovies() {
        
        ArrayList<Movie> movies = new ArrayList<>();
        
        try {
            File filename = new File("src/cinemorepract/Movies.json");
            FileReader reader = new FileReader(filename);
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject)parser.parse(reader);
	    JSONArray moviesJSON = (JSONArray)jsonData.get("movies");

            for (int i = 0; i < moviesJSON.size(); i++) {
                JSONObject movieJSON = (JSONObject)moviesJSON.get(i);
                String title = (String)movieJSON.get("title");
                long year = (long)movieJSON.get("year");
                JSONArray jsonGenre = (JSONArray)movieJSON.get("genres");
                String[] genres = new String[jsonGenre.size()];
                for(int j = 0; j < jsonGenre.size(); j++) {
                    genres[j] = (String)jsonGenre.get(j);
                }
                movies.add(new Movie(title, year, genres));
            }
            
            return movies;
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}