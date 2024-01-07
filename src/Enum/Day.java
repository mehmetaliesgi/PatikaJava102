package Enum;

public class Day {
    public static final Day PAZARTESI = new Day(1);
    public static final Day SALI = new Day(2);
    public static final Day CARSAMBA = new Day(3);
    public static final Day PERSEMBE = new Day(4);
    public static final Day CUMA = new Day(5);
    public static final Day CUMARTESI = new Day(6);
    public static final Day PAZAR = new Day(7);
    private int day;
    private Day(int day) {
        this.day = day;
    }
}
