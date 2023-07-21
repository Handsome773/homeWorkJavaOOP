import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.ServiceFamilyTree;
import human.Human;
import marriage.Marriage;
import saveload.FileHandler;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        int idHuman = 0;
        ServiceFamilyTree<Human> service = new ServiceFamilyTree<>();

        Human alexander = new Human(idHuman++, "Александр", LocalDate.of(1996, 07, 11), Gender.Male);
        System.out.println(String.format("test anton.getAge(): %d", alexander.getAge()));
        Human irina = new Human(idHuman++, "Ирина", LocalDate.of(2001, 05, 04), Gender.Female);
        Human nikita = new Human(idHuman++, "Никита", LocalDate.of(2020, 11, 23), Gender.Male);
        service.addItem(alexander);
        service.addItem(irina);
        service.addItem(nikita);

        alexander.addChild(nikita);
        irina.addChild(nikita);

        Marriage m2 = service.addMarriage(LocalDate.of(2012, 07, 25), irina, alexander);

        service.stopMarriageById(m.getId(), LocalDate.of(2016, 3, 21));
        Human masha = new Human(idHuman++, "Маша", LocalDate.of(1994, 11, 5), Gender.Female);
        service.addItem(masha);
        Marriage m2 = service.addMarriage(LocalDate.of(2017, 2, 12), masha, alexander);

        service.sortItemsByAge();

        System.out.println(String.format("tree info: \n%s", service.getInfoAll()));

        try {
            //Выполняем запись в файл и последующее чтение
            FileHandler filehandler = new FileHandler();
            filehandler.saveTo(service.getTree(), "tree.txt");

            FamilyTree treeOut = (FamilyTree) filehandler.loadFrom("tree.txt");
            //Дублируем вывод:
            System.out.println(String.format("treeOut info: \n%s", treeOut.getInfoAll()));
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}