package PatikaStore;

public class Brands {
    private int brandsId;
    private String brandsName;

    public Brands(int brandsId, String brandsName) {
        this.brandsId = brandsId;
        this.brandsName = brandsName;
    }

    public int getBrandsId() {
        return brandsId;
    }

    public String getBrandsName() {
        return brandsName;
    }
}
