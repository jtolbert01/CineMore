/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConcertLoader {
    
    public static final String CONCERT_FILE = "src/Concerts.json";
    
    public static ArrayList<Concert> loadConcerts() {
        
        ArrayList<Concert> concertList = new ArrayList<>();
        try {
            File filename = new File(CONCERT_FILE);
            FileReader reader = new FileReader(filename);
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject)parser.parse(reader);
            JSONArray concertsJSON = (JSONArray)jsonData.get("concerts");
            
            for (int i = 0; i < concertsJSON.size(); i++) {
                JSONObject concertJSON = (JSONObject)concertsJSON.get(i);
                String title = (String)concertJSON.get("title");
                String headliner = (String)concertJSON.get("headliner");
                JSONArray bands = (JSONArray)concertJSON.get("bands");
                String[] bandList = new String[bands.size()];
                for (int j = 0; j < bandList.length; j++) {
                    bandList[j] = (String)bands.get(j);
                }
                double rating = ((Number)concertJSON.get("rating")).doubleValue();
                
                concertList.add(new Concert(title, headliner, bandList, rating));
            }
            
            return concertList;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
