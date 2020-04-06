/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Ampitheater extends Venue{
    private static final String type = "Ampitheater";
    private Theater theater;
    private int seats;
    private int[][] map;
    
    public Ampitheater(String name, String contact, String address, 
                       int seats, int[][] map) {
        setName(name);
        setContact(contact);
        setAddress(address);
        setSeats(seats);
        setMap(map);
        setType(this.type);
        theater = new Theater(1, seats, map);
    }
    
    public void setSeats(int seats) {
        this.seats = seats;
    }
    
    public void setMap(int[][] map) {
        this.map = map;
    }
    
    public void setTheater(int seats, int[][] map) {
        this.theater = new Theater(1, seats, map);
    }
    
    public int getSeats() {
        return this.seats;
    }
    
    public int[][] getMap() {
        return this.map;
    }
    
    public Theater getTheater() {
        return this.theater;
    }
    
    @Override
    public String toString() {
        return "\nName: " + getName() + "\nContact Number: " + getContact() +
                "\nAddress: " + getAddress() + "\nSeats: " + getSeats();
    }
}
