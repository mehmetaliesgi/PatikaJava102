package PatikaStore;

import java.util.LinkedList;
import java.util.Scanner;

public class PatikaStore {
    public Scanner scanner = new Scanner(System.in);

    public void welcome() {
        System.out.println("Patika Store Ürün Yönetim Paneline Hoş Geldiniz!!!");

        LinkedList<OperationsLists> operationsLinkedList = new LinkedList<>();
        operationsLinkedList.add(new OperationsLists(1, "Notebook İşlemleri"));
        operationsLinkedList.add(new OperationsLists(2, "Cep Telefonu İşlemleri"));
        operationsLinkedList.add(new OperationsLists(3, "Marka Listele"));
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
                    System.out.println("Notebook işlemlerine girdiniz.");
                    operations.notebookLists();
                    kosul = false;
                    break;
                case 2:
                    System.out.println("Cep Telefonu Listesi");
                    operations.cellPhonesLists();
                    kosul = false;
                    break;
                case 3:
                    System.out.println("Markalarımız");
                    System.out.println("-------------------------------------");
                    operations.brandsLists();
                    kosul = false;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir işlem giriniz.");
            }
        }
    }
}
