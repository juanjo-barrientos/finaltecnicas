package helpers;

import java.util.UUID;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import models.Cv;
import models.EducationCV;
import models.ExperienceCV;

public class CvHelper {

    public CvHelper() {
    }

    public Cv generate(JsonObject jsonObject) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        String idUser = jsonObject.get("idUser").toString();
        String name = jsonObject.get("name").toString();
        String currentPosition = jsonObject.get("currentPosition").toString();
        String generalInfo = jsonObject.get("generalInfo").toString();
        ArrayList<ExperienceCV> experience = new ExperienceCVHelper().generate(jsonObject);
        ArrayList<EducationCV> education = new EducationCVHelper().generate(jsonObject);
        HabilitiesAndTagsHelper hatHelper = new HabilitiesAndTagsHelper();
        ArrayList<String> habilities = hatHelper.generateHabilities(jsonObject);
        ArrayList<String> tags = hatHelper.generateTags(jsonObject);
        Cv cv = new Cv(id, idUser, name, currentPosition, generalInfo, experience, education, habilities, tags);

        return cv;
    }


}
