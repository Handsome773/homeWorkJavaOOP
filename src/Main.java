import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Создаем объекты
        Human father = new Human("Александр", LocalDate.of(1996, 07, 11), Gender.Male);
        Human mother = new Human("Ирина", LocalDate.of(2001, 05, 04), Gender.Female);
        Human son = new Human("Никита", LocalDate.of(2020, 11, 23), Gender.Male);

        //Устанавливаем связи
        father.setChild(son);
        mother.setChild(son);

        //Добавляем в общество
        FamilyTree tree = new FamilyTree();
        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);
        System.out.println(String.format("Семья: %s", tree.toString()));
    }
}