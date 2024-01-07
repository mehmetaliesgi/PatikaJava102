package Enum;

public enum DayEnum {
    PAZARTESI(1),
    SALI(2),
    CARSAMBA(3),
    PERSEMBE(4),
    CUMA(5),
    CUMARTESI(6),
    PAZAR(7);

    private int day;

    DayEnum(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
