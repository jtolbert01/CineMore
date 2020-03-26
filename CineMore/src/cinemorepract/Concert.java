/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Concert extends Event {
    private String title;
    private String headliner;
    private String[] bands;
    private double rating;
    private final String eventType = "Concert";
    
    public Concert(String title, String headliner, String[] bands, double rating) {
        this.title = title;
        this.headliner = headliner;
        this.bands = bands;
        this.rating = rating;
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
    
    public String getHeadliner() {
        return this.headliner;
    }
    
    public String[] getBands() {
        return this.bands;
    }
    
    @Override
    public double getRating() {
        return this.rating;
    }
    
    @Override
    public String getEventType() {
        return this.eventType;
    }
    
    public String bandsToString() {
        String bandList = "";
        int bNum = this.bands.length;
        for (int i = 0; i < bNum; i++) {
            if (i == bNum - 1) {
                bandList = bandList.concat(this.bands[i]);
            }
            else {
                bandList = bandList.concat(this.bands[i] + ", ");
            }
        }
        return bandList;
    }
    
    @Override
    public String toString() {
        return "Title: " + this.title + "\n Headliner: " + this.headliner + "\n "
                + "Bands: " + bandsToString() + "\n Rating: " + this.rating;
    }
}
