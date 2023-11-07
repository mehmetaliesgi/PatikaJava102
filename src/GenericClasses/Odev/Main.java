package GenericClasses.Odev;

public class Main {
    public static void main(String[] args) {
        ArrayOperations <Integer> arr = new ArrayOperations<>();
        System.out.println("Dizideki Eleman Sayısı : " + arr.size());
        System.out.println("Dizinin Kapasitesi : " +arr.getCapacity());
        for (int i = 0; i < 12; i ++) {
            arr.addData(i);
        }
        System.out.println("Dizideki Eleman Sayısı : " + arr.size());
        System.out.println("Dizinin Kapasitesi : " +arr.getCapacity());

        System.out.println(arr.get(1));
        arr.remove(7);
        System.out.println("Dizideki Eleman Sayısı : " + arr.size());
        System.out.println("Dizinin Kapasitesi : " +arr.getCapacity());

    }
}
