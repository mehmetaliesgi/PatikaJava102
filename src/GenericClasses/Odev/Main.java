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
        //arr.remove(7);
        System.out.println("Dizideki Eleman Sayısı : " + arr.size());
        System.out.println("Dizinin Kapasitesi : " +arr.getCapacity());

        arr.set(14, 44);
        arr.set(13, 54);
        System.out.println("Dizideki Eleman Sayısı : " + arr.size());
        System.out.println("Dizinin Kapasitesi : " +arr.getCapacity());

        arr.toString();
        System.out.println(arr.indexOf(44));

        arr.set(17, 44);
        System.out.println(arr.lastIndexOf(44));

        System.out.println(arr.isEmpty());

        Object[] dizi = arr.toArray();
        for (Object value : dizi) {
            System.out.print(value + " - ");
        }


        arr.clear();
        /*System.out.println();
        Object[] dizi1 = arr.toArray();
        for (Object value : dizi1) {
            System.out.print(value + " - ");
        }*/
        System.out.println();
        System.out.println(arr.isEmpty());
    }
}
