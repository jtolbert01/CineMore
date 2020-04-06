/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

//This class instantiates a couple theaters for testing
public class CoreVenues {

    public static ArrayList<Venue> loadVenues() {
        ArrayList<Venue> venueList = new ArrayList<>();
        String[] names = {"Cinema18", "Regal IMAX", "Hollywood 20"};
        String[] numbers = {"555-555-5555", "555-555-5551", "555-555-5552"};
        int[] theaters = {7, 10, 8};
        MovieTheater mT = new MovieTheater(names[0], numbers[0], theaters[0]);
        MovieTheater mT1 = new MovieTheater(names[1], numbers[1], theaters[1]);
        MovieTheater mT2 = new MovieTheater(names[2], numbers[2], theaters[2]);
        addTheater(mT, 25, 10);
        addTheater(mT, 20, 10);
        addTheater(mT1, 25, 10);
        addTheater(mT1, 30, 10);
        addTheater(mT2, 25, 10);
        addTheater(mT2, 20, 15);
        venueList.add(mT);
        venueList.add(mT1);
        venueList.add(mT2);
        return venueList;
    }
    
    public static void addTheater(MovieTheater mT, int rows, int cols) {
        int[][] tempMap = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tempMap[i][j] = 0;
            }
        }
        int num = mT.getTheaterNum();
        mT.addTheater(num, (rows * cols), tempMap);
    }
}