/*
 * Joshua S Tolbert
 */

package cinemorepract;


public class Theater{
    private int theaterID;
    private int seatNumber;
    private int[][] seatMap;
    private int rows;
    private int cols;
    
    public Theater(int id, int rows, int cols) {
        setID(id);
        setSeatNumber((rows * cols));
        setMap(rows, cols);
        this.rows = rows;
        this.cols = cols;
    }
    
    public void setSeatNumber(int seats) {
        this.seatNumber = seats;
    }
    
    public void setMap(int rows, int cols) {
        int[][] map = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = 0;
            }
        }
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
        System.out.println("    -------SCREEN-------");
        System.out.print("   ");
        for(int i = 0; i < this.cols; i++) {
            if (i == this.cols - 1) {
                System.out.print(i + "\n");
            } else {
                if (i < 10) {
                    System.out.print(i + "  ");
                } else {
                    System.out.print(i + "  ");
                }
            }
        }
        for (int i = 0; i < this.rows; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.seatMap[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
