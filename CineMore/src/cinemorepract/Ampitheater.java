/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Ampitheater extends Venue{
    private static final String type = "Ampitheater";
    private Theater theater;
    private int seats;
    private int[][] map;
    private int rows;
    private int cols;
    
    public Ampitheater(String name, String contact, String address, 
                       int rows, int cols) {
        setName(name);
        setContact(contact);
        setAddress(address);
        setSeats((rows * cols));
        setMap(rows, cols);
        setType(this.type);
        this.rows = rows;
        this.cols = cols;
        setMainTheater(new Theater(1, rows, cols));
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
    
    public void setTheater(int rows, int cols) {
        this.theater = new Theater(1, rows, cols);
    }
    
    public int getSeats() {
        return this.seats;
    }
    
    public int[][] getMap() {
        return this.map;
    }
    
    public void printMap() {
        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.println(this.map[i][j] + " ");
            }
            System.out.println("");
        }
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
