/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

public abstract class Venue {
    private String name;
    private String contactNum;
    private String venueType;
    private String address;
    private Theater mainTheater;
    
    public void setName(String name) {
        this.name = name;
    }
    
    /*public void addEvent(Event event) {
        events.add(event);
    }
    
    //returns 1 if event not found
    public int removeEvent(String title) {
        for (Event e : events) {
            if (e.getTitle().equalsIgnoreCase(title)) {
                events.remove(e);
                return 0;
            }
        }
        return 1;
    }*/
    
    public void setContact(String contact) {
        this.contactNum = contact;
    }
    
    public void setType(String venueType) {
        this.venueType = venueType;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setMainTheater(Theater t) {
        this.mainTheater = t;
    }
    
    public String getName() {
        return this.name;
    }
    
    /*
    public ArrayList<Event> getEvents() {
        return this.events;
    }*/
    
    public String getContact() {
        return this.contactNum;
    }
    
    public String getType() {
        return this.venueType;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public Theater getMainTheater() {
        return this.mainTheater;
    }
}


