/*
* Jacob A Carter & Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

//Creates instance of Plays to load
public class Plays {
    public static Plays plays = null;
    public static ArrayList<Play> playList = new ArrayList<>();
    
    private Plays() {
        this.playList = PlayLoader.loadPlays();
    }
    
    public static Plays getInstance() {
        if (plays == null) plays = new Plays();
        
        return plays;
    }
    
    public ArrayList<Play> getPlays() {
        return this.playList;
    }
}
