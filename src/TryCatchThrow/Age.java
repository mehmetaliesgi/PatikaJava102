package TryCatchThrow;

import java.util.Scanner;

public class Age {
    public Scanner scanner = new Scanner(System.in);
    private int age;

    public Age() {
        System.out.print("Lütfen yaşınızı giriniz : ");
        age = scanner.nextInt();
        this.age = age;
    }

    public void checkAgeInAgeClass() throws AgeCheckException {
        if (age < 18) {
            throw new AgeCheckException("AgeCheckException sınıfından hata yakalandı!!");
        }
        System.out.println("Yaşınız sokağa çıkmak için uygundur.");
    }
}
