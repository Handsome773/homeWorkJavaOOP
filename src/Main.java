import family_tree.FamilyTree;
import family_tree.ServiceFamilyTree;
import human.Gender;
import human.Human;
import marriage.Marriage;
import saveload.FileHandler;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServiceFamilyTree service = new ServiceFamilyTree();

        Human alexander = service.addHuman("Александр", LocalDate.of(1996, 07, 11), Gender.Male);
        Human irina = service.addHuman("Ирина", LocalDate.of(2001, 05, 04), Gender.Female);
        Human nikita = service.addHuman("Никита", LocalDate.of(2020, 11, 23), Gender.Male);
        System.out.println(String.format("test anton.getAge(): %d", alexander.getAge()));

        alexander.addChild(nikita);
        irina.addChild(nikita);

        Marriage m2 = service.addMarriage(LocalDate.of(2012, 07, 25), irina, alexander);

        service.stopMarriageById(m.getId(), LocalDate.of(2016, 3, 21));
        Human masha = service.addHuman("Маша", LocalDate.of(1996, 10, 11), Gender.Female);
        Marriage m2 = service.addMarriage(LocalDate.of(2017, 2, 12), masha, alexander);

        service.sortHumansByAge();

        System.out.println(String.format("tree info: \n%s", service.getInfoAll()));

        FileHandler filehandler = new FileHandler();
        filehandler.saveTo(service.getTree(), "tree.txt");

        FamilyTree treeOut = (FamilyTree)filehandler.loadFrom("tree.txt");

        System.out.println(String.format("treeOut info: \n%s", treeOut.getInfoAll()));
    }
}