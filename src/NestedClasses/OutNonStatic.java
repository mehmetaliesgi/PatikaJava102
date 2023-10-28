package NestedClasses;

//Outer class
public class OutNonStatic {
    public int sayi = 5;

    //Inner class
    public class In {
        public int sayi = 10;
        public void print() {
            int sayi = 15;
            System.out.println(sayi);
            System.out.println(this.sayi);
            System.out.println(OutNonStatic.this.sayi);
        }
    }
    public void print() {
        In in = new In();
        in.print();
    }

    public In getIn() {
        In in = new In();
        return in;
    }
}
