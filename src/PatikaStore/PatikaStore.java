package PatikaStore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PatikaStore {
    public Scanner scanner = new Scanner(System.in);

    public void welcome() {
        System.out.println("Patika Store Ürün Yönetim Paneline Hoş Geldiniz!!!");

        LinkedList<OperationsLists> operationsLinkedList = new LinkedList<>();
        operationsLinkedList.add(new OperationsLists(1, "Ürünleri Listele"));
        //operationsLinkedList.add(new OperationsLists(2, "Cep Telefonlarını Listele"));
        operationsLinkedList.add(new OperationsLists(2, "Marka Listele"));
        operationsLinkedList.add(new OperationsLists(3, "Marka Ekle"));
        operationsLinkedList.add(new OperationsLists(4, "Ürün Ekle"));
        operationsLinkedList.add(new OperationsLists(5, "Ürün Sil"));
        operationsLinkedList.add(new OperationsLists(6, "Ürün Ara"));
        operationsLinkedList.add(new OperationsLists(7, "Filtrelem Yap!"));
        operationsLinkedList.add(new OperationsLists(0, "Çıkış Yap"));

        Operations operations = new Operations();

        boolean kosul = true;
        while (kosul) {
            for (OperationsLists operation : operationsLinkedList) {
                System.out.println(operation.getOperationId() + " - " + operation.getOperationName());
            }

            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
            int selectOperation = scanner.nextInt();

            switch (selectOperation) {
                case 0:
                    System.out.println("Çıkış Yaptınız!! Güle güle!!");
                    kosul = false;
                    break;
                case 1:
                    operations.productLists();
                    break;
                case 2:
                    for (Brands brand : operations.brandsLists()) {
                        System.out.println(" - " + brand.getBrandsName());
                    }
                    System.out.println("0 - Çıkış");
                    int choose = scanner.nextInt();

                    boolean kosul1 = true;
                    while (kosul1) {
                        switch (choose) {
                            case 0:
                                kosul1 = false;
                                break;
                            default:
                                System.out.println("Geçerli bir işlem seçiniz!!!");
                                System.out.println("0 - Çıkış");
                                choose = scanner.nextInt();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Markalarımız");
                    System.out.println("-------------------------------------");
                    operations.brandAdd();
                    break;
                case 4:
                    operations.productAdd();
                    break;
                case 5:
                    operations.productDelete();
                    break;
                case 6:
                    operations.productSearch();
                    break;
                case 7:
                    operations.filterProductWithBrand();
                    break;
                default:
                    System.out.println("Lütfen geçerli bir işlem giriniz.");
            }
        }
    }
}
