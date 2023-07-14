import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int humanId = 0;

        FamilyTree tree = new FamilyTree();
        Human father = new Human(humanId++, "Александр", LocalDate.of(1996, 07, 11), Gender.Male);
        Human mother = new Human(humanId++, "Ирина", LocalDate.of(2001, 05, 04), Gender.Female);
        Human son = new Human(humanId++, "Никита", LocalDate.of(2020, 11, 23), Gender.Male);
        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);
        father.addChild(son);
        mother.addChild(son);

        Marriage m = tree.addMarriage(LocalDate.of(2012, 07, 25), mother, father);

        m.finish(LocalDate.of(2016, 3, 21));
        Human masha = new Human(humanId++, "Маша", LocalDate.of(1996, 10, 11), Gender.Female);
        tree.addHuman(masha);
        tree.addMarriage(LocalDate.of(2017, 2, 12), masha, father);

        System.out.println(String.format("tree info: \n%s", tree.toString()));
    }
}