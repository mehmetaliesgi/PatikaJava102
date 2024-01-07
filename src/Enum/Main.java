package Enum;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Enum kavramı, bir değişken üzerinden önceden tanımlanmış özel java sabitleridir. Java’da enum kavramı oluşturmuş olduğum programın okunabilirlik düzeyini arttırır
        // ve sağlamış olduğu tip güvenliği ile daha stabil bir altyapı oluşturmaya olanak sağlar.
        // Enum türlerini dışarıdan new operatörü ile türetemeyiz. Java Enum kullanırken içerisinde oluşturulan yapıcı metotlar sadece enum sabitleri tarafından çağrılabilirler.

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen gün numarasını giriniz: ");
        int day = scanner.nextInt();

        for (DayEnum dayEnum: DayEnum.values()) {
            if (day < 8) {
                if (day == dayEnum.getDay()) {
                    System.out.println("Seçtiğiniz gün no: " + dayEnum.getDay() + " Gün ismi: " + dayEnum.name());
                }
            }
            else {
                System.out.println("Hatalı gün numarası girdiniz!!!");
                break;
            }
        }
        */

        Scanner scanner = new Scanner(System.in);
        String userName, userPass, authorityName="Tanımsız";
        int authority;

        UserManager userManager = new UserManager();

        System.out.println("--------------------\n-> Yetkiler:");
        for(StaffMembers s: StaffMembers.values()){
            System.out.println("[" + s.getStaffRank() + "] - " + s.name());
        }
        System.out.println("--------------------");
        System.out.print("-> Kullanıcı Adı:");
        userName = scanner.nextLine();
        System.out.print("-> Şifre:");
        userPass = scanner.nextLine();
        System.out.println("--------------------");
        // Kullanıcı Sisteme Tanımlı Admin'mi Kontrolünü Sağlıyoruz.
        if(userName.equals(userManager.userName) && userPass.equals(userManager.userPass)){
            authority = userManager.authority;
        }
        else {
            authority = 4;
        }
        // Verilen Yetki İsmine Erişmek İçin Kuracağımız For Döngüsü:
        for(StaffMembers s: StaffMembers.values()){
            if(s.getStaffRank()== authority){
                authorityName = s.name();
            }
        }
        System.out.println("-> Hesabınız Başarılı Bir Şekilde Oluşturuldu.");
        System.out.println("--------------------\n< Kullanıcı Bilgileri >\nKullanıcı Adı: "+userName);
        System.out.println("Şifreniz: "+userPass+"\nYetkiniz: "+authorityName+"\n--------------------");

    }
}
