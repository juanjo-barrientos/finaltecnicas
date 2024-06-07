
package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;

public class HabilitiesAndTagsHelper {

    public HabilitiesAndTagsHelper() {
    }
    
    public ArrayList<String> generateHabilities(JsonObject jsonObject){
        JsonArray habilitiesList = jsonObject.getAsJsonArray("habilities");
        ArrayList<String> habilities = new ArrayList<>();

        for (JsonElement item : habilitiesList) {
            habilities.add(item.toString());
        }
        
        return habilities;
    }
    
    public ArrayList<String> generateTags(JsonObject jsonObject){
        JsonArray tagsList = jsonObject.getAsJsonArray("tags");
        ArrayList<String> habilities = new ArrayList<>();

        for (JsonElement item : tagsList) {
            habilities.add(item.toString());
        }
        
        return habilities;
        
    }
    
}
