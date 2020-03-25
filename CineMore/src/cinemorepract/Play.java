/*
* Jacob A Carter & Joshua S Tolbert
 */

package cinemorepract;

//Holds information and Accessors for Plays
public class Play {
    
    private String title;
    private String author;
    private String[] characters;
    private long year;
    
    public Play(String title, String auth, String[] characters, long year) {
        this.title = title;
        this.author = auth;
        this.characters = characters;
        this.year = year;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String[] getCharacters() {
        return this.characters;
    }
    
    public long getYear() {
        return this.year;
    }
}
