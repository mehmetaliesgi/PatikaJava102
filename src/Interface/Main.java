package Interface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tutar giriniz: ");
        double tutar = scanner.nextDouble();
        System.out.print("Kart no giriniz: ");
        String kartNo = scanner.next();
        System.out.print("Son kullanma tarihini giriniz: ");
        String expiryDate = scanner.next();
        System.out.print("Güvenlik kodu giriniz: ");
        String cvc = scanner.next();

        System.out.println("1. A Bankası");
        System.out.println("2. B Bankası");
        System.out.println("3. C Bankası");
        System.out.print("Banka seçiniz: ");
        int selectBank = scanner.nextInt();

        switch (selectBank) {
            case 1:
                BankA posA = new BankA("A Bankası", "111111111111111", "111111");
                posA.connect("127.0.0.2");
                posA.payment(tutar, kartNo, expiryDate, cvc);
                break;

            case 2:
                BankB posB = new BankB("B Bankası", "222222222222222", "222222");
                posB.connect("127.0.0.2");
                posB.payment(tutar, kartNo, expiryDate, cvc);
                break;

            case 3:
                BankC posC = new BankC("C Bankası", "333333333333333", "333333");
                posC.connect("127.0.0.2");
                posC.payment(tutar, kartNo, expiryDate, cvc);
                break;
            default:
                System.out.println("Geçerli bir banka giriniz!");
        }

    }
}
