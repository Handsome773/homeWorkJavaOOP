package family_tree;

import human.Human;
import human.HumanGroup;
import marriage.Marriage;
import marriage.MarriageGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class FamilyTree implements Serializable {
    private HumanGroup humans;
    private MarriageGroup marriages;
    FamilyTree(){
        humans = new HumanGroup();
        marriages = new MarriageGroup();
    }
    void addHuman(Human h){
        humans.add(h);
    }

    void addMarriage(Marriage m){
        marriages.add(m);
    }

    public Human getHumanById(int id){
        for(Human h : humans)
            if(h.getId() == id)
                return h;
        return null;
    }
    public Marriage getMarriageById(int id){
        for(Marriage m : marriages)
            if(m.getId() == id)
                return m;
        return null;
    }

    public String getHumansInfo(){
        return humans.getInfo();
    }
    public String getMarriagesInfo(){
        List<String> strings = new ArrayList<>();
        for (Marriage m : marriages)
            strings.add(m.getInfo());
        return String.join("\n", strings);
    }
    public String getInfoAll(){
        return "{ humans: \n"
                + getHumansInfo()
                + ",\nmarriages: \n"
                + getMarriagesInfo()
                + "\n}";
    }
    public void sortHumansByName(){
        humans.sortByName();
    }

    public void sortHumansByAge(){
        humans.sortByAge();
    }
    @Override
    public String toString() {
        return getInfoAll();
    }
}