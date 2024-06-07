
package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import models.ExperienceCV;

public class ExperienceCVHelper {

    public ExperienceCVHelper() {
    }
    
    public ArrayList<ExperienceCV> generate(JsonObject jsonObject){
        JsonArray experienceList = jsonObject.getAsJsonArray("experience");
        ArrayList<ExperienceCV> experience = new ArrayList<>();

        for (JsonElement item : experienceList) {
            JsonObject experienceItem = item.getAsJsonObject();
            String enterprise = experienceItem.get("enterprise").toString();
            String position = experienceItem.get("position").toString();
            int duration = experienceItem.get("duration").getAsInt();
            String description = experienceItem.get("description").toString();

            ExperienceCV exp = new ExperienceCV(enterprise, position, duration, description);
            experience.add(exp);
        }
        
        return experience;
    }
}
