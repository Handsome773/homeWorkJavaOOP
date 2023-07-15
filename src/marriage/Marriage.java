package marriage;

import human.Gender;
import human.Human;
import java.io.Serializable;
import java.time.LocalDate;

//Класс заключения брака между двумя людьми
public class Marriage implements Serializable {
    private int id;
    private LocalDate startDate, endDate;
    private Human wife, husband;
    private static final int ageAdulthood = 18;
    private boolean isError = false;

    public Marriage(int id, LocalDate startDate, Human wife, Human husband){
        this.id = id;
        this.startDate = startDate;
        if(wife == null || wife.getGender() != Gender.Female
                || wife.getDateBirth().plusYears(ageAdulthood).compareTo(this.startDate) > 0
                || wife.getSpouse() != null) {   //уже в браке
            isError = true;
            return;
        }
        if(husband == null || husband.getGender() != Gender.Male
                || husband.getDateBirth().plusYears(ageAdulthood).compareTo(this.startDate) > 0
                || husband.getSpouse() != null) {
            isError = true;
            return;
        }
        this.wife = wife;
        this.husband = husband;
        wife.setSpouse(husband);
        husband.setSpouse(wife);
    }
    public boolean getIsError(){ return isError; }

    public int getId() {
        return id;
    }

    public boolean stop(LocalDate endDate){
        if(endDate.compareTo(startDate) < 0) return false;
        if(this.endDate != null) return false;
        this.endDate = endDate;
        wife.setSpouse(null);
        husband.setSpouse(null);
        return true;
    }

    public String getInfo(){
        return "{id: " + id
                + ", Супруга: {" + wife.getName() + ", id=" + wife.getId() + '}'
                + ", Супруг: {" + husband.getName() + ", id=" + husband.getId() + '}'
                + ", заключен: " + startDate.toString()
                + (endDate == null ? ", статус: действителен" : ", статус: расторгнут " + endDate.toString())
                + "}";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}