package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Cv {
    
    public String id;
    public String idUser;
    public String name;
    public String currentPosition;
    public String generalInfo;
    public ArrayList<ExperienceCV> experience;
    public ArrayList<EducationCV> education;
    public ArrayList<String> habilities;
    public ArrayList<String> tags;

    public Cv(String id, String idUser, String name, String currentPosition, String generalInfo, ArrayList<ExperienceCV> experience, ArrayList<EducationCV> education, ArrayList<String> habilities, ArrayList<String> tags) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.currentPosition = currentPosition;
        this.generalInfo = generalInfo;
        this.experience = experience;
        this.education = education;
        this.habilities = habilities;
        this.tags = tags;
    }

    

    public Map<String, Object> getCvHashMap() {

        Map<String, Object> data = new HashMap<>();
        data.put("id", this.id);
        data.put("idUser", this.idUser);
        data.put("name", this.name);
        data.put("currentPosition", this.currentPosition);
        data.put("generalInfo", this.currentPosition);
        data.put("experience", this.experience);
        data.put("education", this.education);
        data.put("habilities", this.habilities);
        data.put("tags", this.tags);
        
        return data;
    }

    public Cv() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = generalInfo;
    }

    public ArrayList<ExperienceCV> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<ExperienceCV> experience) {
        this.experience = experience;
    }

    public ArrayList<EducationCV> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<EducationCV> education) {
        this.education = education;
    }

    public ArrayList<String> getHabilities() {
        return habilities;
    }

    public void setHabilities(ArrayList<String> habilities) {
        this.habilities = habilities;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

}
