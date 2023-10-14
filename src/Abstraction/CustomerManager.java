package Abstraction;

import java.util.Scanner;

public class CustomerManager {
    BasePhoneManager basePhoneManager;
    Scanner scanner = new Scanner(System.in);
    int phonePrice;
    double phoneOtv;
    void infoMessage(){
        System.out.println("-----------------\n< Telefon Ücret Bilgileri >\n-----------------");
        System.out.print("-> Telefon Geliş Ücreti: ");
        phonePrice = scanner.nextInt();
        if(phonePrice>=3000){ // OTV Hesaplamasını Yapacak if-else-if sorgusu
            phoneOtv = 0.4;
        }
        else if(phonePrice<=3000 && phonePrice>1500){
            phoneOtv = 0.25;
        }
        else {
            phoneOtv = 0.15;
        }
        System.out.println("-> Hükümlü Olduğunuz ÖTV Ücreti: %"+phoneOtv*100);
    }
    void doTheShopping() {
        System.out.println("-----------------\n< Telefon Bilgileri >\n-----------------");
        System.out.println("-> Telefon Markası: " + basePhoneManager.getPhoneBrand());
        System.out.println("-> Telefon Modeli: " + basePhoneManager.phoneModel);
        System.out.println("-----------------\n< Telefon Hesaplaması >\n-----------------");
        System.out.println("-> Telefon Fiyatı: " + basePhoneManager.buyTelephone(phonePrice, phoneOtv));
        System.out.println("-----------------");
    }
}
