/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.ArrayList;

//This class instantiates a couple theaters for testing
public class CoreVenues {

    public static ArrayList<Venue> loadVenues() {
        ArrayList<Venue> venueList = new ArrayList<>();
        String[] names = {"Cinema18", "Regal IMAX", "Morgan Ampitheater", "NewLight Ampitheater"};
        String[] numbers = {"555-555-5555", "555-555-5551", "555-555-5552", "555-555-5553"};
        String[] addresses = {"123 Some Road, City, State, 11111",
                              "124 Some Street, City, State, 11112",
                              "125 Some Circle, City, State, 11113",
                              "126 Some Court, City, State, 11114"};
        int[] theaters = {7, 10, 8};
        MovieTheater mT = new MovieTheater(names[0], numbers[0], addresses[0],
                                           theaters[0]);
        MovieTheater mT1 = new MovieTheater(names[1], numbers[1], addresses[1],
                                           theaters[1]);
        Ampitheater mT2 = new Ampitheater(names[2], numbers[2], addresses[2],
                                          70, 50);
        Ampitheater mt3 = new Ampitheater(names[3], numbers[3], addresses[3],
                                          60, 50);
        addTheater(mT, 25, 10);
        addTheater(mT, 20, 10);
        addTheater(mT1, 25, 10);
        addTheater(mT1, 30, 10);
        venueList.add(mT);
        venueList.add(mT1);
        venueList.add(mT2);
        venueList.add(mt3);
        return venueList;
    }
    
    public static void addTheater(MovieTheater mT, int rows, int cols) {
        int[][] tempMap = getTheater(rows, cols);
        int num = mT.getTheaterNum();
        mT.addTheater(num, (rows * cols), tempMap);
    }
    
    public static int[][] getTheater(int rows, int cols) {
        int[][] tempMap = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tempMap[i][j] = 0;
            }
        }
        return tempMap;
    }
}