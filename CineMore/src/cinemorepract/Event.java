/*
 * Joshua S Tolbert
 */

package cinemorepract;


public abstract class Event {
    protected String title;
    protected double rating;
    protected String eventType;
   
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
