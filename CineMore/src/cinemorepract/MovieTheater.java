/*
 * Joshua S Tolbert
 */

package cinemorepract;

public class MovieTheater extends Venue {
    private int maxTheaters;
    private Theater[] theaters;
    private static final String type = "Movie Theater";
    private int theaterNum;
    
    public MovieTheater(String name, String contactNum, String address, int maxTheaters) {
        setName(name);
        setContact(contactNum);
        setType(this.type);
        setMaxTheaters(maxTheaters);
        setAddress(address);
        this.theaters = new Theater[getMaxTheaters()];
        theaterNum = 0;
    }
    
    public void setMaxTheaters(int num) {
        this.maxTheaters = num;
    }
    
    public int getMaxTheaters() {
        return this.maxTheaters;
    }
    
    public void addTheater(int id, int seats, int[][] map) {
        for (int i = 0; i < getMaxTheaters(); i++) {
            if (theaters[i] == null) {
                theaters[i] = new Theater(id, seats, map);
                return;
            }
        }
        theaterNum++;
        System.out.println("The Maximum Theater Number Has Been Reached.");
    }
    
    public int getTheaterNum() {
        return this.theaterNum;
    }
    @Override
    public String toString() {
        return "\nName: " + getName() + "\nContact Number: " + getContact() +
                "\nAddress: " + getAddress() + "\nNumber of Theaters: " + 
                getMaxTheaters();
    }
    
}
