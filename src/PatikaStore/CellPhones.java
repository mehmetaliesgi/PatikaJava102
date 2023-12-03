package PatikaStore;

public class CellPhones {
    private int phoneId;
    private int phoneIMEI;
    private double phonePrice;
    private double phoneDiscount;
    private int phoneStockCount;
    private String phoneName;
    private String phoneBrand;
    private int phoneMemorySize;
    private double phoneScreenSize;
    private int phoneBattary;
    private int phoneRAM;
    private String phoneColor;

    public CellPhones(int phoneId, int phoneIMEI, double phonePrice, double phoneDiscount, int phoneStockCount, String phoneName, String phoneBrand, int phoneMemorySize, double phoneScreenSize, int phoneBattary, int phoneRAM, String phoneColor) {
        this.phoneId = phoneId;
        this.phoneIMEI = phoneIMEI;
        this.phonePrice = phonePrice;
        this.phoneDiscount = phoneDiscount;
        this.phoneStockCount = phoneStockCount;
        this.phoneName = phoneName;
        this.phoneBrand = phoneBrand;
        this.phoneMemorySize = phoneMemorySize;
        this.phoneScreenSize = phoneScreenSize;
        this.phoneBattary = phoneBattary;
        this.phoneRAM = phoneRAM;
        this.phoneColor = phoneColor;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public int getPhoneIMEI() {
        return phoneIMEI;
    }

    public double getPhonePrice() {
        return phonePrice;
    }

    public double getPhoneDiscount() {
        return phoneDiscount;
    }

    public int getPhoneStockCount() {
        return phoneStockCount;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public int getPhoneMemorySize() {
        return phoneMemorySize;
    }

    public double getPhoneScreenSize() {
        return phoneScreenSize;
    }

    public int getPhoneBattary() {
        return phoneBattary;
    }

    public int getPhoneRAM() {
        return phoneRAM;
    }

    public String getPhoneColor() {
        return phoneColor;
    }
}
