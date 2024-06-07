
package models;


public class EducationCV {
    public String institute;
    public String studies;
    public String duration;

    public EducationCV(String institute, String studies, String duration) {
        this.institute = institute;
        this.studies = studies;
        this.duration = duration;
    }

    public EducationCV() {
    }
    
    

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
    
    
}
