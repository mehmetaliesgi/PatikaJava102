package NestedClasses;

public class Local {
    public void print() {
        class Yerel {
            private int sayi;

            public Yerel(int sayi) {
                this.sayi = sayi;
            }
            public int getSayi() {
                return sayi;
            }

            public void setSayi(int sayi) {
                this.sayi = sayi;
            }
        }
        Yerel yerel = new Yerel(25);
        System.out.println("Local sınıfı oluşturuldu.");
        System.out.println(yerel.getSayi());
    }
    public void run() {
        //Yapılamaz. Çünkü Yerel classı sadece run metodu içersinde kullanılabilir.
        //Yerel yerel = new Yerel(25);
    }
}
