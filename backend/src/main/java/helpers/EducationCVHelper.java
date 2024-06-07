
package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import models.EducationCV;

public class EducationCVHelper {

    public EducationCVHelper() {
    }
    
    public ArrayList<EducationCV> generate(JsonObject jsonObject){
        
        JsonArray educationList = jsonObject.getAsJsonArray("education");
        ArrayList<EducationCV> education = new ArrayList<>();

        for (JsonElement item : educationList) {
            JsonObject educationItem = item.getAsJsonObject();
            String institute = educationItem.get("institute").toString();
            String studies = educationItem.get("studies").toString();
            String duration = educationItem.get("duration").toString();

            EducationCV ed = new EducationCV(institute, studies, duration);
            education.add(ed);
        }
        
        return education;
    }
    
}
