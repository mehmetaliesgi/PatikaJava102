package PatikaStore;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Operations {
    public Scanner scanner = new Scanner(System.in);

    public TreeSet<CellPhones> cellPhonesTreeSet = new TreeSet<>(new Comparator<CellPhones>() {
        @Override
        public int compare(CellPhones o1, CellPhones o2) {
            return o1.getPhoneId() - o2.getPhoneId();
        }
    });
    public TreeSet brandsTreeSet = new TreeSet<>(new Comparator<Brands>() {
        @Override
        public int compare(Brands o1, Brands o2) {
            return o1.getBrandsName().compareTo(o2.getBrandsName());
        }
    });
    public TreeSet<Brands> brandsLists() {
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

        return brandsTreeSet;
    }

    public void brandAdd()
    {
        System.out.println("Marka Ekle: ");
        System.out.print("Marka Id Giriniz: ");
        int brandId = scanner.nextInt();
        System.out.print("Marka İsmi Giriniz: ");
        String brandName = scanner.next();
        brandsTreeSet.add(new Brands(brandId, brandName));
    }

    public void productAdd() {
        System.out.println("Ürün Ekle");
        brandsLists();
        boolean kosul = true;
        while (kosul) {
            System.out.println("0 - Çıkış Yap");
            for (ProductCategories productCategory : ProductCategories.productCategories()) {
                System.out.println(productCategory.getProductCategoriesID() + " - " + productCategory.getProductCategoriesName());
            }
            System.out.print("Lütfen kategori seçiniz: ");
            int category = scanner.nextInt();

            switch (category) {
                case 0:
                    System.out.println("İşlem yapmadan çıktınız tekrar bekleriz :)");
                    kosul = false;
                    break;
                case 1:
                    cellPhonesTreeSet.add(cellPhoneAdd());
                    System.out.println("Ürün Eklendi...");
                    break;
                case 2:
                    System.out.println("Bilgisayar eklenecek");
                    break;
                default:
                    System.out.println("Lütfen geçerli bir kategori seçiniz!!!");
            }
        }
    }
    public void cellPhonesLists() {
        System.out.println("Cep Telefonu Listesi");

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
        System.out.println("Notebook işlemlerine girdiniz.");
        TreeSet<Notebooks> notebooksTreeSet = new TreeSet<>(new Comparator<Notebooks>() {
            @Override
            public int compare(Notebooks o1, Notebooks o2) {
                return o1.getNotebookID() - o2.getNotebookID();
            }
        });

        notebooksTreeSet.add(new Notebooks(1, 11111, "LENOVO V14 IGL", 3000, 10, "Lenevo", 8, 512, 14));
        notebooksTreeSet.add(new Notebooks(2, 22222, "ASUS Tuf Gaming",4000, 20, "Asus\t", 16, 512, 14));
        notebooksTreeSet.add(new Notebooks(3, 33333, "HUAWEI Matebook",5000, 30, "Huawei", 8, 512, 14));
        notebooksTreeSet.add(new Notebooks(4, 44444, "Macbook Pro 14",6000, 40, "Apple\t", 32, 512, 14));

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("| ID |\tÜrün Adı\t\t\t\t| Fiyat\t\t\t| Marka\t\t| Depolama\t | Ekran\t| RAM\t|");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Notebooks notebook : notebooksTreeSet) {
            System.out.println("| " + notebook.getNotebookID() + " |\t" + notebook.getNotebookName() + "\t\t\t| " + notebook.getNotebookPrice() + " TL\t\t| " +
                    notebook.getNotebookBrand() + "\t| " + notebook.getNotebookMemory() + " GB\t | " + notebook.getNotebookScreenSize() + " inc\t| " +
                    + notebook.getNotebookRAM() + " GB\t|");
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public CellPhones cellPhoneAdd(){
        System.out.print("Lütfen Ürün ID giriniz: ");
        int phoneID = scanner.nextInt();
        System.out.print("Ürün IMEI numarasını giriniz: ");
        int phoneIMEI = scanner.nextInt();
        System.out.print("Ürün fiyarını giriniz: ");
        scanner.nextLine();
        double phonePrice = scanner.nextDouble();
        System.out.print("Ürün indirimini giriniz: ");
        double phoneDiscount = scanner.nextDouble();
        System.out.print("Stoğa kaç ürün eklenecek: ");
        int phoneStockCount = scanner.nextInt();
        System.out.print("Ürün ismini giriniz: ");
        scanner.nextLine();
        String phoneName = scanner.nextLine();
        System.out.print("Ürün markasını giriniz: ");
        //brandsLists();
        String phoneBrand = scanner.next();

        boolean kosul = true;
        boolean isThere = false;
        while (kosul) {
            Iterator<Brands> itr = brandsTreeSet.iterator();
            while (itr.hasNext()) {
                if (itr.next().getBrandsName().equals(phoneBrand)) {
                    System.out.println("Markalarımızdan birini seçtiniz!");
                    kosul = false;
                    isThere = true;
                    break;
                }
            }

            if (isThere) {
                break;
            } else {
                System.out.println("Lütfen aşağıdaki markadalardan birini giriniz: ");
                for (Brands brand : brandsLists()) {
                    System.out.println(" - " + brand.getBrandsName());
                }
                System.out.print("Ürün markasını giriniz: ");
                phoneBrand = scanner.next();
            }
        }
        System.out.print("Lütfen ürün hafıza kapasitesini giriniz: ");
        int phoneMemory = scanner.nextInt();
        System.out.print("Lütfen ürün ekran boyutunu giriniz: ");
        double phoneScreenSize = scanner.nextDouble();
        System.out.print("Lütfen batarya kapasitesini giriniz: ");
        int phoneBattary = scanner.nextInt();
        System.out.print("Lütfen telefon RAM bilgisini giriniz: ");
        int phoneRAM = scanner.nextInt();
        System.out.print("Lütfen telefon rengini giriniz: ");
        String phoneColor = scanner.next();

        CellPhones cellPhone = new CellPhones(phoneID, phoneIMEI, phonePrice, phoneDiscount, phoneStockCount, phoneName, phoneBrand, phoneMemory, phoneScreenSize, phoneBattary, phoneRAM, phoneColor);
        return cellPhone;
    }

    public void productLists() {

        boolean kosul = true;
        while (kosul) {
            for (ProductCategories productCategory : ProductCategories.productCategories()) {
                System.out.println(productCategory.getProductCategoriesID() + " - " + productCategory.getProductCategoriesName());
            }
            System.out.println("0 - Çıkış");
            System.out.print("Lütfen seçiminizi yapınız: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 0:
                    System.out.println("Ürün listeleme ekranından çıktınız!!!");
                    kosul = false;
                    break;
                case 1:
                    cellPhonesLists();
                    break;
                case 2:
                    notebookLists();
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz!!!");
            }
        }
    }
/*
    public void productCategoriesList(){
        System.out.println("-------------Kategoriler-------------");
        for (ProductCategories productCategories: ProductCategories.productCategories()) {
            System.out.println(productCategories.getProductCategoriesID() + " - " + productCategories.getProductCategoriesName());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void selectCategory() {
        System.out.println("Lütfen işlem yapmak istediğiniz kategoriyi seçiniz: ");
        int select = scanner.nextInt();

        switch (select) {
            case 0:
                System.out.println("Çıkış Yaptınız!!!");
                break;
            case 1:

        }
    }*/
}
