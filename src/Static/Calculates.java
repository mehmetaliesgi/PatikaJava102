package Static;

public class Calculates {
    //public static void calculateAvarage(int[] notes) {
    public static void calculateAvarage(Course[] notes) {

            double total = 0.0;
        for (Course course : notes) {
            total += course.note;
        }
        double avarage = total / notes.length;
        System.out.println("Ortalamanız: " + avarage);
    }
}
