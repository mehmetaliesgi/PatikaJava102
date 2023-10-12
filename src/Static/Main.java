package Static;

public class Main {
    public static void main(String[] args) {
        Course mat = new Course("Matematik", "MAT-101", 70);
        Course fiz = new Course("Fizik", "FİZ-101", 20);
        Course kim = new Course("Kimya", "KİM-101", 60);

        int[] notes = {mat.note, fiz.note, kim.note};
        Course[] notess = {mat, fiz, kim};

        /* Bu şekilde static bir metot kullanmadığımızda calculateAvarage metodunu çağırmak için bir nesne kullanmak zorunda kaldık.
        // Fazladan işlem yaptık. Burada nesne oluşturmaya gerek olmadan metodu static yapalım.
        Calculates cal = new Calculates();
        cal.calculateAvarage(notes);
        */

        // Veya başka bir kullanım olarak aşağıdaki gibi yapabiliriz. Note değerinde değil de direkt olarak Course nesnesini gönderip işleyebiliriz.
        // Calculates.calculateAvarage(notes);
        Calculates.calculateAvarage(notess);
    }
}
