package TryCatchThrow;

import java.util.Scanner;

public class Main {

    public static void checkAge(int age) throws Exception {
        //throw ile kendi exception koşullarımızı oluşturabiliriz.
        if (age < 18) {
            throw new Exception("Yaşınız sokağa çıkmak için uygun değildir!!");
        }

        System.out.println("Yaşınız uygundur.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Yaşınızı giriniz: ");
        int age = input.nextInt();
        //try - catch blogu exception oluşturabilecek kod bloklarının runtime hatası vermeden programı tamamlamasına olanak sağlar.
        try {
            checkAge(age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------------------");

        Age checkWithAgeCheckException = new Age();
        try {
            checkWithAgeCheckException.checkAgeInAgeClass();
        } catch (AgeCheckException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program bitti...");
    }
}
