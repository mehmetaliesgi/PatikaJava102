package InsuranceManagementSystem.Address;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AddressManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void addAddress(ArrayList<IAddress> addresses) {
        String addressName;
        String address;

        boolean kosul = true;
        while (kosul) {
            System.out.println("\n1 - Home Address \n2 - Bussiness Address\n3 - Adres İşlemleri Çıkış");
            System.out.print("Lütfen adress tipini seçiniz: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Lütfen adres ismini giriniz: ");
                    addressName = scanner.nextLine();
                    System.out.print("Lütfen tam adresi giriniz: ");
                    address = scanner.nextLine();
                    addresses.add(new HomeAddress(addressName, address));
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Lütfen adres ismini giriniz: ");
                    addressName = scanner.nextLine();
                    System.out.print("Lütfen tam adresi giriniz: ");
                    address = scanner.nextLine();
                    addresses.add(new BusinessAddress(addressName, address));
                    break;
                case 3:
                    System.out.println("Adres ekleme işleminden çıkış yapıldı!!");
                    kosul = false;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz!!!");
            }
            reListAddresses(addresses);
        }
    }

    public static void deleteAddress(ArrayList<IAddress> addresses) {
        printAddresses(addresses);

        System.out.print("Silmek istediğiniz adresin ID sini giriniz: ");
        int indexAddress = scanner.nextInt();

        if ((indexAddress > addresses.size() + 1) || (indexAddress < 0)) {
            System.out.println("Lütfen geçerli bir değer giriniz: ");
            indexAddress = scanner.nextInt();
        } else {
          addresses.remove(indexAddress -1);
        }
    }

    public static void printAddresses(ArrayList<IAddress> addresses) {
        int i = 0;
        System.out.println("-------------------Addresses-------------------");
        for (IAddress address : addresses) {
            System.out.println(++i + " - " + address.toString());
        }
        System.out.println("-----------------------------------------------");
    }
    public static void reListAddresses(ArrayList<IAddress> addresses) {
        addresses.sort(new Comparator<IAddress>() {
            @Override
            public int compare(IAddress o1, IAddress o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }


}
