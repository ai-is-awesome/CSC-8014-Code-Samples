package uk.ac.ncl.teach.ex.factory.name;

public class UseName {
    public static void main(String[] args) {
        String fn1 = "John";
        String fn2 = "Smith";

        Name name1 = Name.getInstance(fn1, fn2);
        Name name2 = Name.getInstance("Jen", "Jones");
        Name name3 = Name.getInstance("John", "Smith");

        System.out.println("name1 same object as name2?" + (name1 == name2));
        System.out.println("name1 same object as name3?" + (name1 == name3));
    }
}