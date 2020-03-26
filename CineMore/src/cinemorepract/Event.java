/*
 * Joshua S Tolbert
 */

package cinemorepract;


public abstract class Event {
    private String title;
    private double rating;
    private String eventType;
   
    public String getTitle() {
        return this.title;
    }
    
    public double getRating() {
        return this.rating;
    }
    
    public String getEventType() {
        return this.eventType;
    }
}
