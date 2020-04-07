/*
 * Joshua S Tolbert
 */

package cinemorepract;

import java.util.HashMap;
import java.util.ArrayList;


public abstract class Event {
    private String title;
    private double rating;
    private String eventType;
    private ArrayList<Review> reviews = new ArrayList<Review>();
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
    //Adds a new review
    public void newReview(int star) {
    	Review reviewX = new Review(star);
    	this.reviews.add(reviewX);
    }
    public void newReview(int star, String review) {
    	Review reviewX = new Review(star, review);
    	this.reviews.add(reviewX);
    }
    //Get event reviews
    public ArrayList<Review> getReviews() {
    	return this.reviews;
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
            System.out.println("");
        }
    }
    
    public String getEventType() {
        return this.eventType;
    }
}
