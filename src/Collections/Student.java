package Collections;

public class Student {
    private String name;
    private int vizeNote;
    private int finalNote;
    private double avgNote;

    public Student(String name, int vizeNote, int finalNote) {
        this.name = name;
        this.vizeNote = vizeNote;
        this.finalNote = finalNote;
        avgNote = (vizeNote * 0.4) + (finalNote * 0.6);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVizeNote() {
        return vizeNote;
    }

    public void setVizeNote(int vizeNote) {
        this.vizeNote = vizeNote;
    }

    public int getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(int finalNote) {
        this.finalNote = finalNote;
    }

    public double getAvgNote() {
        return avgNote;
    }
}
