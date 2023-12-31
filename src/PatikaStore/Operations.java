package PatikaStore;

import java.util.*;

public class Operations {
    public Scanner scanner = new Scanner(System.in);
    public TreeSet<CellPhones> cellPhonesTreeSet = new TreeSet<>(new Comparator<CellPhones>() {
        @Override
        public int compare(CellPhones o1, CellPhones o2) {
            return o1.getPhoneId() - o2.getPhoneId();
        }
    });
    public TreeSet<Notebooks> notebooksTreeSet = new TreeSet<>(new Comparator<Notebooks>() {
        @Override
        public int compare(Notebooks o1, Notebooks o2) {
            return o1.getNotebookID() - o2.getNotebookID();
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

    public void brandAdd() {
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
                    notebooksTreeSet.add(notebookAdd());
                    System.out.println("Ürün Eklendi...");
                    break;
                default:
                    System.out.println("Lütfen geçerli bir kategori seçiniz!!!");
            }
        }
    }
    public TreeSet<CellPhones> cellPhonesLists() {
        cellPhonesTreeSet.add(new CellPhones(1, 11111, 1000, 10, 20, "Samsung Galaxy A51", "Samsung", 128, 6.0, 6500, 64, "Black"));
        cellPhonesTreeSet.add(new CellPhones(2, 22222, 2000, 20, 30, "iPhone 11\t\t", "Apple", 512, 6.2, 4500, 64, "Silver"));
        cellPhonesTreeSet.add(new CellPhones(3, 33333, 3000, 30, 40, "Huawei Mate 40 Pro", "Huawei", 256, 5.8, 5000, 64, "Yellow"));
        cellPhonesTreeSet.add(new CellPhones(4, 44444, 3000, 30, 40, "Huawei Mate 50 Pro", "Huawei", 256, 5.8, 5000, 64, "Silver"));
        cellPhonesTreeSet.add(new CellPhones(5, 55555, 3000, 30, 40, "Huawei Mate 60 Pro", "Huawei", 256, 5.8, 5000, 64, "Green"));
        cellPhonesTreeSet.add(new CellPhones(6, 66666, 4000, 40, 50, "Redmi Note 12 Pro", "Xiaomi", 128, 5.5, 6000, 64, "Green"));

        return cellPhonesTreeSet;
    }
    public void cellPhoneListsPrint(TreeSet<CellPhones> cellPhones) {
        System.out.println("Cep Telefonu Listesi");
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
    public TreeSet<Notebooks> notebookLists() {
        notebooksTreeSet.add(new Notebooks(1, 11111, "LENOVO V14 IGL", 3000, 10, "Lenevo", 8, 512, 14.0));
        notebooksTreeSet.add(new Notebooks(2, 22222, "ASUS Tuf Gaming",4000, 20, "Asus\t", 16, 512, 14.0));
        notebooksTreeSet.add(new Notebooks(3, 33333, "HUAWEI Matebook",5000, 30, "Huawei", 8, 512, 14.0));
        notebooksTreeSet.add(new Notebooks(4, 44444, "Macbook Pro 14",6000, 40, "Apple", 32, 512, 14.0));
        notebooksTreeSet.add(new Notebooks(5, 55555, "Macbook Pro 15",7000, 40, "Apple", 64, 512, 14.0));
        notebooksTreeSet.add(new Notebooks(6, 66666, "Macbook Pro 16",8000, 40, "Apple", 64, 512, 14.0));

        return notebooksTreeSet;
    }

    public void notebookListsPrint(TreeSet<Notebooks> notebooks) {
        System.out.println("Notebook listemiz!!!");

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

    public Notebooks notebookAdd(){
        System.out.print("Lütfen Ürün ID giriniz: ");
        int notebookID = scanner.nextInt();
        System.out.print("Ürün IMEI numarasını giriniz: ");
        int notebookIMEI = scanner.nextInt();
        System.out.print("Ürün fiyarını giriniz: ");
        scanner.nextLine();
        double notebookPrice = scanner.nextDouble();
        System.out.print("Ürün indirimini giriniz: ");
        double notebookDiscount = scanner.nextDouble();
        System.out.print("Ürün ismini giriniz: ");
        scanner.nextLine();
        String notebookName = scanner.nextLine();
        System.out.print("Ürün markasını giriniz: ");
        String notebookBrand = scanner.next();

        boolean kosul = true;
        boolean isThere = false;
        while (kosul) {
            Iterator<Brands> itr = brandsTreeSet.iterator();
            while (itr.hasNext()) {
                if (itr.next().getBrandsName().equals(notebookBrand)) {
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
                notebookBrand = scanner.next();
            }
        }
        System.out.print("Lütfen ürün hafıza kapasitesini giriniz: ");
        int notebookMemory = scanner.nextInt();
        System.out.print("Lütfen ürün ekran boyutunu giriniz: ");
        double notebookScreenSize = scanner.nextDouble();
        System.out.print("Lütfen RAM bilgisini giriniz: ");
        int notebookRAM = scanner.nextInt();

        Notebooks notebook = new Notebooks(notebookID, notebookIMEI, notebookName, notebookPrice, notebookDiscount, notebookBrand, notebookRAM, notebookMemory, notebookScreenSize);
        return notebook;
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
                    cellPhoneListsPrint(cellPhonesLists());
                    break;
                case 2:
                    notebookListsPrint(notebookLists());
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz!!!");
            }
        }
    }

    public void productDelete() {
        System.out.println("Hangi kategoriden ürün silmek istersiniz? ");
        for (ProductCategories productCategory : ProductCategories.productCategories()) {
            System.out.println(productCategory.getProductCategoriesID() + " - " + productCategory.getProductCategoriesName());
        }
        System.out.println("0 - İptal");

        System.out.print("Lütfen seçinizi yapınız: ");
        int choose = scanner.nextInt();

        boolean kosul = true;
        while (kosul) {
            switch (choose) {
                case 0:
                    System.out.println("İşlem iptal edildi!!!");
                    break;
                case 1:
                    cellPhonesLists();
                    System.out.print("Lütfen silmek istediğiniz ürünün IMEI numarasını giriniz: ");
                    int phoneIMEI = scanner.nextInt();
                    if (deleteCellPhone(phoneIMEI) != null) {
                        cellPhonesTreeSet.remove(deleteCellPhone(phoneIMEI));
                        System.out.println("Ürün silme işlemi gerçekleşti!!!");
                        System.out.println("Silinen ürün: " + deleteCellPhone(phoneIMEI).getPhoneName() + ", IMEI no: " + deleteCellPhone(phoneIMEI).getPhoneIMEI());
                    } else {
                        System.out.println("Böyle bir IMEI numaralı ürün bulunmamaktadır. Lütfen IMEI numarasını kontrol ediniz!!");
                    }
                    break;
                case 2:
                    notebookLists();
                    System.out.print("Lütfen silmek istediğiniz ürünün IMEI numarasını giriniz: ");
                    int notebookIMEI = scanner.nextInt();
                    if (deleteNotebook(notebookIMEI) != null) {
                        notebooksTreeSet.remove(deleteNotebook(notebookIMEI));
                        System.out.println("Ürün silme işlemi gerçekleştirildi!!!");
                        System.out.println("Silinen ürün: " + deleteNotebook(notebookIMEI).getNotebookName() + ", IMEI no: " + deleteNotebook(notebookIMEI).getNotebookIMEI());
                    } else {
                        System.out.println("Böyle bir IMEI numaralı ürün bulunmamaktadır. Lütfen IMEI numarasını kontrol ediniz!!");
                    }
                    break;
                default:
                    System.out.print("Yanlış bir değer girdiniz. Lütfen tekrar deneyiniz!!! ");
                    choose = scanner.nextInt();
            }
            kosul = false;
        }
    }

    public CellPhones deleteCellPhone(int phoneIMEI) {
        CellPhones cellPhone = null;
        for (CellPhones CP : cellPhonesTreeSet) {
            if (CP.getPhoneIMEI() == phoneIMEI) {
                cellPhone = CP;
            }
        }
        return cellPhone;
    }

    public Notebooks deleteNotebook(int notebookIMEI) {
        Notebooks notebook = null;
        for (Notebooks nb : notebooksTreeSet) {
            if (nb.getNotebookIMEI() == notebookIMEI) {
                notebook = nb;
            }
        }
        return notebook;
    }

    public CellPhones searchCellPhone(int productIMEI) {
        CellPhones cp = null;
        for (CellPhones cellPhone : cellPhonesTreeSet) {
            if (cellPhone.getPhoneIMEI() == productIMEI) {
                cp = cellPhone;
                break;
            }
        }
        return cp;
    }

    public Notebooks searchNotebook(int productIMEI) {
        Notebooks nb = null;
        for (Notebooks notebook : notebooksTreeSet) {
            if (notebook.getNotebookIMEI() == productIMEI) {
                nb = notebook;
                break;
            }
        }
        return nb;
    }

    public void productSearch() {
        boolean kosul = true;
        cellPhonesLists();
        notebookLists();
        while (kosul) {
            System.out.println("1 - Arama Yap!!");
            System.out.println("0 - Çıkış");

            System.out.println("Lütfen işlem tipi seçiniz: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 0:
                    System.out.println("Arama işlemi sayfasından çıkış yapıldı!!!");
                    kosul = false;
                    break;

                case 1:
                    System.out.print("Lütfen ürünün IMEI numarasını giriniz: ");
                    int productIMEI = scanner.nextInt();

                    if (searchCellPhone(productIMEI) != null) {
                        System.out.println("Aradığınız ürün: " + searchCellPhone(productIMEI).getPhoneName());
                    } else if (searchNotebook(productIMEI) != null) {
                        System.out.println("Aradığınız ürün: " + searchNotebook(productIMEI).getNotebookName());
                    } else {
                        System.out.println(productIMEI + " numaralı bir ürününüz bulunmamaktadır.");
                    }
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz!!!");
            }
        }
    }

    public ArrayList<CellPhones> filterCellPhoneWithBrand(String productBrand) {
        ArrayList<CellPhones> cellPhonesList = new ArrayList<>();
        for (CellPhones cellPhone : cellPhonesTreeSet) {
            if (cellPhone.getPhoneBrand().equals(productBrand)) {
                cellPhonesList.add(cellPhone);
            }
        }
        return cellPhonesList;
    }

    public ArrayList<Notebooks> filterNotebookWithBrand(String productBrand) {
        ArrayList<Notebooks> notebooksList = new ArrayList<>();
        for (Notebooks notebook : notebooksTreeSet) {
            if (notebook.getNotebookBrand().equals(productBrand)) {
                notebooksList.add(notebook);
            }
        }
        return notebooksList;
    }

    public void filterProductWithBrand() {
        cellPhonesLists();
        notebookLists();

        boolean kosul = true;
        while (kosul) {
            System.out.println("Lütfen yapmak istediğiniz işlemi giriniz: ");
            System.out.println("1 - Filtreleme Yap ");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 0:
                    System.out.println("Çıkış yaptınız!!!");
                    kosul = false;
                    break;
                case 1:
                    System.out.print("Lütfen filtrelem işlemi yapmak istediğiniz Marka'yı giriniz: ");
                    scanner.nextLine();
                    String productBrand = scanner.nextLine();
                    filterCellPhoneWithBrand(productBrand);
                    filterNotebookWithBrand(productBrand);

                    if (filterCellPhoneWithBrand(productBrand) != null) {
                        System.out.println("Cep Telefonu Markaları:  ");
                        for (CellPhones cellPhone : filterCellPhoneWithBrand(productBrand)) {
                            System.out.println("IMEI No: " + cellPhone.getPhoneIMEI() + ", Cep Telefonu İsmi: " + cellPhone.getPhoneName());
                        }
                    }
                    if (filterNotebookWithBrand(productBrand) != null) {
                        System.out.println("Notebook Markaları: ");
                        for (Notebooks notebook : filterNotebookWithBrand(productBrand)) {
                            System.out.println("IMEI No: " + notebook.getNotebookIMEI() + ", Notebook İsmi: " + notebook.getNotebookName());
                        }
                    } else {
                        System.out.println(productBrand + " Markasında bir ürün bulunamadı!!!");
                    }
                    break;
                default:
                    System.out.println("Lütfen geçerli bir işlem seçiniz!!!");
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
