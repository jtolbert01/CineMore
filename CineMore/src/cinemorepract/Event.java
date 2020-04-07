/*
 * Joshua S Tolbert
 */

package cinemorepract;

import java.util.HashMap;


public abstract class Event {
    private String title;
    private double rating;
    private String eventType;
    HashMap<Venue, String> showings = new HashMap<>();
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setShowing(Venue venue, String time) {
        showings.put(venue, time);
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
   
    public String getTitle() {
        return this.title;
    }
    
    public double getRating() {
        return this.rating;
    }
    
    public HashMap<Venue, String> getShowings() {
        return this.showings;
    }
    
    public void printShowings() {
        for(Venue v : showings.keySet()) {
            System.out.println("Venue: " + v.toString());
            System.out.println("Time: " + showings.get(v));
        }
    }
    
    public String getEventType() {
        return this.eventType;
    }
}
