package GenericClasses;

public class Main {
    public static void main(String[] args) {
        /*Nullable<String> nullable = new Nullable<>("ABCD");
        System.out.println(nullable.toString());

        Nullable<Integer> nullable1 = new Nullable<>(25);
        System.out.println(nullable1.toString());

        Double value = null;
        Nullable<Double> nullable2 = new Nullable<>(value);
        System.out.println(nullable2.toString());*/
        Student<String> student1 = new Student<>();
        Student<Integer> student2 = new Student<>();
        student1.insert("Student");
        student2.insert(1234);
    }
}
