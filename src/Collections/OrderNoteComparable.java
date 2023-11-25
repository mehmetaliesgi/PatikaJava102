package Collections;

import java.util.Comparator;

public class OrderNoteComparable implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getAvgNote() - o2.getAvgNote());
    }
}
