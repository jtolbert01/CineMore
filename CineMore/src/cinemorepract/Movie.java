/*
 * Jacob A Carter & Joshua S Tolbert
 */

package cinemorepract;

//Holds Information and Accessors for Movies
public class Movie {
    private String title;
    private String[] genres;
    private long year;
    
    public Movie(String title, long year, String[] genres) {
        this.title = title;
        this.year = year;
        this.genres = genres;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public long getYear() {
        return this.year;
    }
    
    public String[] getGenres() {
        return this.genres;
    }
    
    
}
