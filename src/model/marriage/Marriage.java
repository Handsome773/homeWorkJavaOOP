package family_tree.model.marriage;

import family_tree.model.Gender;
import family_tree.model.Informer;
import family_tree.model.group.ItemFamilyTree;
import family_tree.model.human.Human;
import java.io.Serializable;
import java.time.LocalDate;

//Класс заключения брака между двумя людьми
public class Marriage<T extends ItemFamilyTree<T>> implements Serializable {
    int id;
    LocalDate startDate, endDate;
    T wife, husband;
    private static final int ageAdulthood = 18;
    private boolean isError = false;
    private Informer<Marriage<T>> informer;

    public Marriage(int id, LocalDate startDate, T wife, T husband, Informer<Marriage<T>> informer){
        this.id = id;
        this.startDate = startDate;
        this.informer = informer;
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
        return informer.getInfo(this);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}