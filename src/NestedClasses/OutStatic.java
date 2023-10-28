package NestedClasses;

public class OutStatic {
    public int sayi = 5;
    public static int sayi2= 20;
    public static class InStatic {
        public static int sayi = 10;
        public static void print() {
            System.out.println("InStatic sınıfına ait print metodu çalıştı.");
            int sayi = 15;
            System.out.println(sayi);
            System.out.println(InStatic.sayi);
            System.out.println(OutStatic.sayi2);
        }
    }
}
