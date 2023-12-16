package InsuranceManagementSystem.Account;

import InsuranceManagementSystem.Address.AddressManager;
import InsuranceManagementSystem.Address.IAddress;
import InsuranceManagementSystem.Exceptions.InvalidAuthenticationException;

import java.util.*;

public class AccountManager {
    public static Scanner scanner = new Scanner(System.in);
    TreeSet<Account> accounts = new TreeSet<>();
    static ArrayList<User> users = new ArrayList<>();

    static ArrayList<IAddress> addresses = new ArrayList<>();
    private static AuthenticationStatus isLogin = AuthenticationStatus.FAIL;
    private static User userL;

    public static void createAccount() {
        scanner.nextLine();
        System.out.print("Adınız: ");
        String name = scanner.nextLine();
        System.out.print("Soyadınız: ");
        String surname = scanner.nextLine();
        System.out.print("Email adresiniz: ");
        String email = scanner.nextLine();
        System.out.print("Şifre belirleyiniz: ");
        String password = scanner.nextLine();
        System.out.print("Mesleğiniz: ");
        String job = scanner.nextLine();
        System.out.print("Yaşınız: ");
        int age = scanner.nextInt();
        System.out.print("Adres giriniz: ");
        AddressManager.addAddress(addresses);

        Date firstDate = new Date();
        User user = new User(name, surname, email, password, job, age, addresses, firstDate);
        users.add(user);
    }

    public static void login() throws InvalidAuthenticationException {
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        for (User user : users) {
            if ((user.getEmail().equals(email)) & (user.getPassword().equals(password))) {
                isLogin = AuthenticationStatus.SUCCESS;
                userL = user;
                break;
            }
        }

        if (isLogin == AuthenticationStatus.SUCCESS) {
            System.out.println("Login Olundu!!!");
        }
        else {
            throw new InvalidAuthenticationException("Hatalı bilgiler girildi. Bilgilerinizi kontrol edip tekrar deneyiniz.");
        }

        boolean kosul = true;
        while (kosul) {
            System.out.println("Sayın "+ userL.getName()+" Hoşgeldiniz!!!! " +
                    "\n1 - Kullanıcı Bilgilerini Göster" +
                    "\n2 - Adres İşlemlerim" +
                    "\n3 - Çıkış Yap");
            System.out.print("Lütfen İşlem Türü Seçiniz: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    userInfo();
                    break;
                case 2:
                    updateAddress();
                    break;
                case 3:
                    logout();
                    System.out.println("Çıkış Yaptınız!!!");
                    kosul = false;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir işlem giriniz!!!");
            }
        }
    }

    public static void logout() {
        isLogin = AuthenticationStatus.FAIL;
    }

    public static void userInfo() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Kullanıcı Adı: " + userL.getName() + "\nKullanıcı Email: " + userL.getEmail());
        for (IAddress address : userL.getAddresses()) {
            System.out.println(address.toString());
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void updateAddress() {
        System.out.println("Adres işlemlerine hoş geldiniz!!!");
        boolean kosul = true;
        while (kosul) {
            System.out.println("Adres İşlemler " +
                    "\n1 - Adres Ekle" +
                    "\n2 - Adres Sil" +
                    "\n3 - Adresleri Listele" +
                    "\n4 - Adres İşlemlerinden Çık");
            System.out.print("Lütfen işlem türünü giriniz: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    AddressManager.addAddress(userL.getAddresses());
                    break;
                case 2:
                    AddressManager.deleteAddress(userL.getAddresses());
                    break;
                case 3:
                    AddressManager.printAddresses(userL.getAddresses());
                    break;
                case 4:
                    System.out.println("Adres işlemlerinden çıkış yaptınız!!!");
                    kosul = false;
                    break;
                default:
                    System.out.println("Lürfen geçerli işlem giriniz!!!");
            }
        }
    }
    public static void listUsers() {
        for (User user: users) {
            System.out.println("Usar Name: " + user.getName());
        }
    }
}
