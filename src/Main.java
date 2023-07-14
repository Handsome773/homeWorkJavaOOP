import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int humanId = 0;

        FamilyTree tree = new FamilyTree();
        Human alexander = new Human(humanId++, "Александр", LocalDate.of(1996, 07, 11), Gender.Male);
        Human irina = new Human(humanId++, "Ирина", LocalDate.of(2001, 05, 04), Gender.Female);
        Human nikita = new Human(humanId++, "Никита", LocalDate.of(2020, 11, 23), Gender.Male);
        tree.addHuman(alexander);
        tree.addHuman(irina);
        tree.addHuman(nikita);
        alexander.addChild(nikita);
        irina.addChild(nikita);

        Marriage m = tree.addMarriage(LocalDate.of(2012, 07, 25), irina, alexander);

        m.finish(LocalDate.of(2016, 3, 21));
        Human masha = new Human(humanId++, "Маша", LocalDate.of(1996, 10, 11), Gender.Female);
        tree.addHuman(masha);
        tree.addMarriage(LocalDate.of(2017, 2, 12), masha, alexander);

        System.out.println(String.format("tree info: \n%s", tree.toString()));

        FileHandler filehandler = new FileHandler();
        filehandler.SaveTo(tree, new String[] {"tree.txt"});

        FamilyTree treeOut = (FamilyTree)filehandler.LoadFrom(new String[] {"tree.txt"});

        System.out.println(String.format("treeOut info: \n%s", treeOut.toString()));
    }
}