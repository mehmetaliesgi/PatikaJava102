package InsuranceManagementSystem.Account;

import InsuranceManagementSystem.Insurance.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account implements Comparable<Account>{
    public static Scanner scanner = new Scanner(System.in);
    private final double rate;
    private AuthenticationStatus status;
    private User user;
    private static ArrayList<Insurance> insurances;

    Account(User user, double rate) {
        this.user = user;
        this.insurances = new ArrayList<>();
        this.rate = rate;
    }

    final void showUserInfo() {
        System.out.println(user.toString());
    }

    public int compareTo(Account account) {
        return this.user.getEmail().compareTo(account.user.getEmail());
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public static void listInsurance() {
        for (Insurance insurance : insurances) {
            System.out.println("Sigorta: " + insurance.getInsuranceName());
        }
    }

    public static void addInsurance() {
        boolean kosul = true;
        while (kosul) {
            System.out.println("İşlem yapabileceğiniz Sigorta Türleri: " +
                    "\n1 - Araba" +
                    "\n2 - Sağlık" +
                    "\n3 - Rezidans" +
                    "\n4 - Seyehat" +
                    "\n5 - Çıkış Yap" +
                    "\nLütfen seçinizi yapınız: ");
            int choose = scanner.nextInt();

            System.out.print("Lütfen sigrota ismini giriniz: ");
            String insuranceName = scanner.next();
            System.out.print("Lütfen sigorta fiyatını giriniz: ");
            double insurancePrice = scanner.nextDouble();
            System.out.print("Lütfen sigortanın kaç yıllık olduğunu giriniz: ");
            int insuraneYear = scanner.nextInt();
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = myDateObj.format(myFormatObj);
            LocalDate insuranceDate = LocalDate.parse(formattedDate);
            LocalDate finishDate = insuranceDate.plusYears(insuraneYear);

            switch (choose) {
                case 1:
                    insurances.add(new CarInsurance(insuranceName, insurancePrice, insuranceDate, finishDate));
                    break;
                case 2:
                    insurances.add(new HealthInsurance(insuranceName, insurancePrice, insuranceDate, finishDate));
                    break;

                case 3:
                    insurances.add(new ResidenceInsurance(insuranceName, insurancePrice, insuranceDate, finishDate));
                    break;

                case 4:
                    insurances.add(new TravelInsurance(insuranceName, insurancePrice, insuranceDate, finishDate));
                    break;

                default:
                    System.out.println("Lütfen geçerli bir işlem seçiniz!!!");
            }
            kosul = false;
        }
    }
}
