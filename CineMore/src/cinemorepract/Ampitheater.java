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
                       int rows, int cols) {
        setName(name);
        setContact(contact);
        setAddress(address);
        setSeats((rows * cols));
        setMap(rows, cols);
        setType(this.type);
        theater = new Theater(1, seats, map);
    }
    
    public void setSeats(int seats) {
        this.seats = seats;
    }
    
    public void setMap(int rows, int col) {
        int[][] newM = new int[rows][col];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                newM[i][j] = 0;
            }
        }
        this.map = newM;
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
