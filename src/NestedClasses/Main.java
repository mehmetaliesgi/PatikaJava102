package NestedClasses;

public class Main {
    public static void main(String[] args) {

        //NON STATIC
        OutNonStatic outNonStatic = new OutNonStatic();
        //out.print();
        //Out.In in = out.new In();
        OutNonStatic.In in = outNonStatic.getIn();
        //in.print();

        //STATIC
        OutStatic.InStatic.print();

        //LOCAL
        Local local = new Local();
        local.print();

        //ANONIM
        Anonim anonim1 = new Anonim();
        Anonim anonim = new Anonim() {
            public int sayi = 50;
            @Override
            public void run() {
                System.out.println("Ananim olarak yazılmuş run metodu!");
                print();
                System.out.println(this.sayi + " sayısı nesne içinde üretilmiştir.");
            }
            public void print() {
                System.out.println("Print metodu nesneden ulaşılamaz. Fakat override edilen metodda çağırılabilir.");
            }
        };
        anonim.run();
        //anonim.print();   Kullanılamaz fakat yukarıdaki gibi override edilen metod içersinde kullanılabilir.
        anonim1.run();
    }
}
