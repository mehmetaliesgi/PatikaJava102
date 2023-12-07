package PatikaStore;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Operations {
    public void brandsLists() {
        TreeSet<Brands> brandsTreeSet = new TreeSet<>(new Comparator<Brands>() {
            @Override
            public int compare(Brands o1, Brands o2) {
                return o1.getBrandsName().compareTo(o2.getBrandsName());
            }
        });
        //Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster
        brandsTreeSet.add(new Brands(1, "Samsung"));
        brandsTreeSet.add(new Brands(2, "Lenovo"));
        brandsTreeSet.add(new Brands(3, "Apple"));
        brandsTreeSet.add(new Brands(4, "Huawei"));
        brandsTreeSet.add(new Brands(5, "Casper"));
        brandsTreeSet.add(new Brands(6, "Asus"));
        brandsTreeSet.add(new Brands(7, "HP"));
        brandsTreeSet.add(new Brands(8, "Xiamoi"));
        brandsTreeSet.add(new Brands(9, "Monster"));

        Iterator<Brands> itr = brandsTreeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(" - " + itr.next().getBrandsName());
        }
    }

    public void cellPhonesLists() {
        TreeSet<CellPhones> cellPhonesTreeSet = new TreeSet<>(new Comparator<CellPhones>() {
            @Override
            public int compare(CellPhones o1, CellPhones o2) {
                return o1.getPhoneId() - o2.getPhoneId();
            }
        });

        cellPhonesTreeSet.add(new CellPhones(1, 11111, 1000, 10, 20, "Samsung Galaxy A51", "Samsung", 128, 6.0, 6500, 64, "Black"));
        cellPhonesTreeSet.add(new CellPhones(2, 22222, 2000, 20, 30, "iPhone 11\t\t", "Apple\t", 512, 6.2, 4500, 64, "Silver"));
        cellPhonesTreeSet.add(new CellPhones(3, 33333, 3000, 30, 40, "Huawei Mate 40 Pro", "Huawei", 256, 5.8, 5000, 64, "Yellow"));
        cellPhonesTreeSet.add(new CellPhones(4, 44444, 4000, 40, 50, "Redmi Note 12 Pro", "Xiaomi", 128, 5.5, 6000, 64, "Green"));

        //Iterator<CellPhones> iterator = cellPhonesTreeSet.iterator();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID |\tÜrün Adı\t\t\t\t\t| Fiyat\t\t\t| Marka\t\t| Depolama\t | Ekran\t| Pil\t\t| RAM\t\t| Renk \t\t|");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        for (CellPhones cellPhone : cellPhonesTreeSet) {
            System.out.println("| " + cellPhone.getPhoneId() + " |\t" + cellPhone.getPhoneName() + "\t\t\t| " + cellPhone.getPhonePrice() + " TL\t\t| " +
                    cellPhone.getPhoneBrand() + "\t| " + cellPhone.getPhoneMemorySize() + " GB\t | " + cellPhone.getPhoneScreenSize() + " inc\t| " +
                    cellPhone.getPhoneBattary() + "\t\t| " + cellPhone.getPhoneRAM() + " GB\t\t| " + cellPhone.getPhoneColor() + " \t|");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    public void notebookLists() {
        TreeSet<Notebooks> notebookssTreeSet = new TreeSet<>(new Comparator<Notebooks>() {
            @Override
            public int compare(Notebooks o1, Notebooks o2) {
                return o1.getNotebookID() - o2.getNotebookID();
            }
        });

        notebookssTreeSet.add(new Notebooks(1, 11111, "LENOVO V14 IGL", 3000, 10, "Lenevo", 8, 512, 14));
        notebookssTreeSet.add(new Notebooks(2, 22222, "ASUS Tuf Gaming",4000, 20, "Asus\t", 16, 512, 14));
        notebookssTreeSet.add(new Notebooks(3, 33333, "HUAWEI Matebook",5000, 30, "Huawei", 8, 512, 14));
        notebookssTreeSet.add(new Notebooks(4, 44444, "Macbook Pro 14",6000, 40, "Apple\t", 32, 512, 14));

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("| ID |\tÜrün Adı\t\t\t\t| Fiyat\t\t\t| Marka\t\t| Depolama\t | Ekran\t| RAM\t|");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Notebooks notebook : notebookssTreeSet) {
            System.out.println("| " + notebook.getNotebookID() + " |\t" + notebook.getNotebookName() + "\t\t\t| " + notebook.getNotebookPrice() + " TL\t\t| " +
                    notebook.getNotebookBrand() + "\t| " + notebook.getNotebookMemory() + " GB\t | " + notebook.getNotebookScreenSize() + " inc\t| " +
                    + notebook.getNotebookRAM() + " GB\t|");
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
