package PatikaStore;

public class Notebooks {
    private int notebookID;
    private int notebookIMEI;
    private String notebookName;
    private double notebookPrice;
    private double notebookDiscount;
    private String notebookBrand;
    private int notebookRAM;
    private int notebookMemory;
    private int notebookScreenSize;

    public Notebooks(int notebookID, int notebookIMEI, String notebookName, double notebookPrice, double notebookDiscount, String notebookBrand, int notebookRAM, int notebookMemory, int notebookScreenSize) {
        this.notebookID = notebookID;
        this.notebookIMEI = notebookIMEI;
        this.notebookName = notebookName;
        this.notebookPrice = notebookPrice;
        this.notebookDiscount = notebookDiscount;
        this.notebookBrand = notebookBrand;
        this.notebookRAM = notebookRAM;
        this.notebookMemory = notebookMemory;
        this.notebookScreenSize = notebookScreenSize;
    }

    public int getNotebookID() {
        return notebookID;
    }

    public int getNotebookIMEI() {
        return notebookIMEI;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public double getNotebookPrice() {
        return notebookPrice;
    }

    public double getNotebookDiscount() {
        return notebookDiscount;
    }

    public String getNotebookBrand() {
        return notebookBrand;
    }

    public int getNotebookRAM() {
        return notebookRAM;
    }

    public int getNotebookMemory() {
        return notebookMemory;
    }

    public int getNotebookScreenSize() {
        return notebookScreenSize;
    }
}
