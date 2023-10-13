package Encapsulation;

public class Main {
    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", 250);
        Book lordOfTheRings = new Book("Lord Of The Rings", -1000);

        System.out.println(harryPotter.getBookName());
        System.out.println(harryPotter.getpageCount());

        System.out.println(lordOfTheRings.getBookName());
        System.out.println(lordOfTheRings.getpageCount());
        lordOfTheRings.setpageCount(1000);
        System.out.println(lordOfTheRings.getpageCount());
        lordOfTheRings.setpageCount(-100);
        System.out.println(lordOfTheRings.getpageCount());
    }
}
