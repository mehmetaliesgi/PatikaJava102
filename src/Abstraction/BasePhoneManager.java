package Abstraction;

public abstract class BasePhoneManager {
    private String phoneBrand; // Telefon Markası İçin Değişkenimiz.
    public String phoneModel; // Telefon Modelimizi Hafızasında Tutacak Değişken
    public void setPhoneBrand(String phoneBrand){
        this.phoneBrand = phoneBrand; // Telefon Markamızı Belirledik.
    }
    public String getPhoneBrand() {
        return phoneBrand;
    }
    public abstract double buyTelephone(int price,double otv);
}
