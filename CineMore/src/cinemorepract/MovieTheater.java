/*
 * Joshua S Tolbert
 */

package cinemorepract;

public class MovieTheater extends Venue {
    private int maxTheaters;
    private Theater[] theaters;
    private int theater_rows = 25;
    private int theater_cols = 10;
    private static final String type = "Movie Theater";
    private int theaterNum;
    
    public MovieTheater(String name, String contactNum, String address, int maxTheaters) {
        setName(name);
        setContact(contactNum);
        setType(this.type);
        setMaxTheaters(maxTheaters);
        setAddress(address);
        this.theaters = new Theater[getMaxTheaters()];
        setMainTheater(new Theater(1, theater_rows, theater_cols));
        theaterNum = 0;
    }
    
    public void setMaxTheaters(int num) {
        this.maxTheaters = num;
    }
    
    public int getMaxTheaters() {
        return this.maxTheaters;
    }
    
    public void addTheater(int id, int rows, int cols) {
        for (int i = 0; i < getMaxTheaters(); i++) {
            if (theaters[i] == null) {
                theaters[i] = new Theater(id, rows, cols);
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
