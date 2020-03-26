/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

public class Concerts {
    public static Concerts concerts = null;
    public static ArrayList<Concert> concertList = new ArrayList<>();
    
    private Concerts() {
        concertList = ConcertLoader.loadConcerts();
    }
    
    public static Concerts getInstance() {
        if (concerts == null) concerts = new Concerts();
        return concerts;
    }
    
    public ArrayList<Concert> getConcerts() {
        return this.concertList;
    }
    
}
