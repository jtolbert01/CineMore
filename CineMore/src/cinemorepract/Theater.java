/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Theater extends Venue{
    private int theaterID;
    private int seatNumber;
    private int[][] seatMap;
    
    public Theater(int id, int seats, int[][] map) {
        setID(id);
        setSeatNumber(seats);
        setMap(map);
    }
    
    public void setSeatNumber(int seats) {
        this.seatNumber = seats;
    }
    
    public void setMap(int[][] map) {
        this.seatMap = map;
    }
    
    public void setID(int id) {
        this.theaterID = id;
    }
    
    public int getSeatNumber() {
        return this.seatNumber;
    }
    
    public int[][] getMap() {
        return this.seatMap;
    }
    
    public int getID() {
        return this.theaterID;
    }
    
    public void printMap() {
        System.out.println("Seat Map");
        for (int i = 0; i < this.seatMap.length; i++) {
            for (int j = 0; j < this.seatMap.length; j++) {
                System.out.println(this.seatMap[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
