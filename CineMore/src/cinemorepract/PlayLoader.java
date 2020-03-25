/*
* Jacob A Carter & Joshua S Tolbert
 */

package cinemorepract;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//Loads plays from JSON and stores them in an ArrayList
public class PlayLoader {
    
    public static final String PLAY_FILE = "src/cinemorepract/Plays.json";
    
    public static ArrayList<Play> loadPlays() {
        
        ArrayList<Play> plays = new ArrayList<>();
        
        try {
            File filename = new File(PLAY_FILE);
            FileReader reader = new FileReader(filename);
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject)parser.parse(reader);
            JSONArray playsJSON = (JSONArray)jsonData.get("plays");
            
            for (int i = 0; i < playsJSON.size(); i++) {
                JSONObject playJSON = (JSONObject)playsJSON.get(i);
                String title = (String)playJSON.get("title");
                String author = (String)playJSON.get("author");
                JSONArray chars = (JSONArray)playJSON.get("characters");
                String[] characters = new String[chars.size()];
                for (int j = 0; j < chars.size(); j++) {
                    characters[j] = (String)chars.get(j);
                }
                long year = (long)playJSON.get("year");
                plays.add(new Play(title, author, characters, year));
            }
            
            return plays;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
