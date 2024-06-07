package models;

public class ExperienceCV {

    public String enterprise;
    public String position;
    public int duration;
    public String description;

    public ExperienceCV(String enterprise, String position, int duration, String description) {
        this.enterprise = enterprise;
        this.position = position;
        this.duration = duration;
        this.description = description;
    }

    public ExperienceCV() {
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    

}
