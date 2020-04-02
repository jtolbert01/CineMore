/*
* Jacob A Carter & Joshua S Tolbert
 */

package cinemorepract;

//Holds information and Accessors for Plays
public class Play extends Event {
    
    private String author;
    private String[] characters;
    private long year;
    private long runtime;
    private final String eventType = "Play";
    
    public Play(String title, String auth, String[] characters, long year, long runtime,
                double rating) {
        setTitle(title);
        this.author = auth;
        this.characters = characters;
        this.year = year;
        this.runtime = runtime;
        setRating(rating);
        setEventType(eventType);
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
    
    public long getRuntime() {
        return this.runtime;
    }
    
    public String charToString() {
        String chars = "";
        int cNum = this.characters.length;
        for (int i = 0; i < cNum; i++) {
            if (i == cNum - 1) {
                chars = chars.concat(this.characters[i]);
            }
            else {
                chars = chars.concat(this.characters[i] + ", ");
            }
        }
        return chars;
    }
    
    @Override
    public String toString() {
        return "Title: " + getTitle() + "\n Author: " + getAuthor() + "\n "
                + "Characters: " + charToString() + "\n Year: " + getYear() + 
                "\n Runtime: " + getRuntime() + " mins\n Rating: " + getRating();
    }
}
