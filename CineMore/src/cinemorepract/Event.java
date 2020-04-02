/*
 * Joshua S Tolbert
 */

package cinemorepract;


public abstract class Event {
    private String title;
    private double rating;
    private String eventType;
    
    public void setTitle(String title) {
        this.title = title;
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
    
    public String getEventType() {
        return this.eventType;
    }
}
