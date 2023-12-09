package PatikaStore;

import java.util.ArrayList;

public class ProductCategories {
    private int productCategoriesID;
    private String productCategoriesName;

    public ProductCategories(int productCategoriesID, String productCategoriesName) {
        this.productCategoriesID = productCategoriesID;
        this.productCategoriesName = productCategoriesName;
    }

    public static ArrayList<ProductCategories> productCategories() {
        ArrayList<ProductCategories> productCategories = new ArrayList<>();
        productCategories.add(new ProductCategories(1, "CellPhones"));
        productCategories.add(new ProductCategories(2, "Notebooks"));

        return productCategories;
    }

    public int getProductCategoriesID() {
        return productCategoriesID;
    }

    public String getProductCategoriesName() {
        return productCategoriesName;
    }
}
