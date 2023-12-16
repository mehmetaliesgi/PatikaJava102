package InsuranceManagementSystem;

import InsuranceManagementSystem.Account.Account;
import InsuranceManagementSystem.Account.AccountManager;
import InsuranceManagementSystem.Account.User;
import InsuranceManagementSystem.Exceptions.InvalidAuthenticationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAuthenticationException {
        Scanner scanner = new Scanner(System.in);
        /*ArrayList<IAddress> addresses = new ArrayList<>();

        AddressManager.printAddresses(addresses);
        AddressManager.addAddress(addresses);
        AddressManager.addAddress(addresses);
        AddressManager.printAddresses(addresses);
        AddressManager.addAddress(addresses);
        AddressManager.deleteAddress(addresses);
        AddressManager.printAddresses(addresses);
        */


        boolean kosul = true;
        while (kosul) {
            System.out.println("İşlem Listesi: \n1 - Login\n2 - Creat an Account\n3 - Exit");
            System.out.print("İşleminizi Seçiniz: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Login Metoduna Gidecek");
                    try {
                        AccountManager.login();
                    } catch (InvalidAuthenticationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Yeni hesap oluşturmaya gidecek");
                    AccountManager.createAccount();
                    AccountManager.listUsers();
                    break;
                case 3:
                    System.out.println("Çıkış Yaptınız!!!");
                    kosul = false;
                    break;
                default:
                    System.out.println("Geçersiz işlem girildi. Tekrar deneyiniz!!!");
            }
        }
    }
}
