package GenericClasses;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        /*Nullable<String> nullable = new Nullable<>("ABCD");
        System.out.println(nullable.toString());

        Nullable<Integer> nullable1 = new Nullable<>(25);
        System.out.println(nullable1.toString());

        Double value = null;
        Nullable<Double> nullable2 = new Nullable<>(value);
        System.out.println(nullable2.toString());*/

/*        Student<String> student1 = new Student<>();
        Student<Integer> student2 = new Student<>();
        student1.insert("Student");
        student2.insert(1234);*/

        Integer number = null;
        NullableBounded <Integer> n = new NullableBounded<>(number);
        System.out.println(n.toString());

        BigDecimal bigDecimal = BigDecimal.valueOf(6.5);
        NullableBounded <BigDecimal> n1 = new NullableBounded<>(bigDecimal);
        System.out.println(n1.toString());

        /*
        Number sınıfından olmayan bir veri tipi denersek hata alacağız.
        Aldığımız hata: Type parameter 'java.lang.Character' is not within its bound; should extend 'java.lang.Number'
        Character character = 'A';
        NullableBounded <Character> n2 = new NullableBounded<>(character);
        */
    }
}
