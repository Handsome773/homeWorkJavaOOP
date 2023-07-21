package family_tree;

import marriage.Marriage;
import java.time.LocalDate;

public class ServiceFamilyTree<T extends ItemFamilyTree<T>> {
    private int idMarriage;
    private FamilyTree<T> tree;

    public ServiceFamilyTree(){
        tree = new FamilyTree<>();
    }

    public void addItem(T t){
        tree.add(t);
    }
    //регистрируем брак и возвращаем ссылку на экземпляр
    //Если нарушены условия, return null
    public Marriage addMarriage(LocalDate startDate, T wife, T husband){
        Marriage m = new Marriage(idMarriage, startDate, wife, husband);
        if(m.getIsError()) return null;
        tree.addMarriage(m);
        idMarriage++;
        return m;
    }
    // добавляем связь родитель - потомок
    public boolean addChild(T parent, T child){
        return parent.addChild(child);
    }
//    public boolean addChild(int idParent, int idChild){
//        Human parent = getHumanById(idParent);
//        if(parent==null) return false;
//        Human child = getHumanById(idChild);
//        if(child==null) return false;
//        return parent.addChild(child);
//    }
    //return null, если список пуст либо id вне имеющихся
    public T getItemById(int id){
        return tree.getItemById(id);
    }

    //return null, если список пуст либо id вне имеющихся
    public Marriage getMarriageById(int id){
        return tree.getMarriageById(id);
    }

    public boolean stopMarriageById(int id, LocalDate date){
        Marriage m = tree.getMarriageById(id);
        if(m == null) return false; // брак не найден
        return m.stop(date);
    }
    public String getHumansInfo(){
        return tree.getItemsInfo();
    }
    public String getMarriagesInfo(){
        return tree.getMarriagesInfo();
    }

    public void sortItemsByName(){
        tree.sortItemsByName();
    }
    public void sortItemsByAge(){
        tree.sortItemsByAge();
    }
    public String getInfoAll(){
        return tree.getInfoAll();
    }

    public FamilyTree getTree(){
        return tree;
    }
}