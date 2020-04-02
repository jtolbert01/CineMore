/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Concert extends Event {
    private String headliner;
    private String[] bands;
    private final String eventType = "Concert";
    
    public Concert(String title, String headliner, String[] bands, double rating) {
        setTitle(title);
        this.headliner = headliner;
        this.bands = bands;
        setRating(rating);
        setEventType(eventType);
    }
    
    public String getHeadliner() {
        return this.headliner;
    }
    
    public String[] getBands() {
        return this.bands;
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
        return "Title: " + getTitle() + "\n Headliner: " + getHeadliner() + "\n "
                + "Bands: " + bandsToString() + "\n Rating: " + getRating();
    }
}
