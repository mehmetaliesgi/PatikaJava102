package DependencyComposition;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Mehmet Ali", "Eşgi", "123", "Address", 80);
        Student student2 = new Student("Kodluyoruz", "Java102", "124", "Address Kodluyoruz", 77);
        Student student3 = new Student("Patika", "Dev", "125", "Address Patika", 111);
        student3.setNote(100);

        Instructor instructor = new Instructor("Ali", "Kemal", "CENG");

        Course mat = new Course("Matematik", "MAT-101", instructor);
        System.out.println(mat.getInstructor().getName());
        Student[] students = {student1, student2, student3};
        System.out.println("Ortalama: " + mat.calculateAvarage(students));
    }
}
