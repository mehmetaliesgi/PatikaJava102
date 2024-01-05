package StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        /*
            Java Stream API, Liste Dizi işlemek için işlevsel işlemler sağlar. Java Stream API, Java 8'e diğer birçok işlevsel programlama özelliğiyle eklendi.
            Listeler ve Dizilerde çok daha kolay ve temiz kod yazılarak işlem yapılabilmektedir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
            Streamler kullanılırken Java 8 ile birlikte gelen Lambda Expression Syntax’ı kullanılmaktadır.
        */

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(25);
        arrayList.add(0);
        arrayList.add(58);
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(5);
        arrayList.add(15);
        arrayList.add(35);
        arrayList.add(125);
        arrayList.add(25);

        // forEach metodu, Collectiondaki değerler üzerinde gezinmemize ve işlem yapmamıza olanak sağlar.
        arrayList.stream().forEach(value -> System.out.println(value));

        // filter metodu, Collectionlar üzerinde filtreleme işlemi yapar
        arrayList.stream().filter(value -> value > 25).forEach(value -> {
            System.out.println("Dizideki " +value + " değeri 25'den büyüktür.");
            System.out.println(value);});

        // distinct metodu ise Collectionda tekrar eden değerleri almaz. Sadece 1 tanesini alır.
        arrayList.stream().distinct().forEach(value -> System.out.print(value + " - "));

        System.out.println();

        // sorted metodu ise collecionda üyeler arası sıralama yapar.
        arrayList.stream().sorted().forEach(value -> System.out.print(value + " - "));
        // eğer büyükten küçüğe bir sıralama yapmak istersek Comparator kullanabiliriz.
        System.out.println();
        arrayList.stream().sorted(Comparator.reverseOrder()).forEach(value -> System.out.print(value + " - "));
        // Harflerde aynı şekilde sıralanır.
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Ayşe");
        nameList.add("Kemal");
        nameList.add("Mustafa");
        System.out.println();
        nameList.stream().sorted().forEach(value -> System.out.print(value + " - "));
        System.out.println();
        nameList.stream().sorted(Comparator.reverseOrder()).forEach(value -> System.out.print(value + " - "));

        // limit metodu ise belirli bir sayıdaki index değerlerini döndürür. İlk 5 değer, ilk 10 değer gibi...
        System.out.println();
        arrayList.stream().limit(3).forEach(value -> System.out.print(value + " - "));
        System.out.println();
        arrayList.stream().sorted().limit(3).forEach(value -> System.out.print(value + " - "));

        // skip metodu ise belirli bir indexe kadar ki değerleri yok sayar ve belirlediğimiz index değerinde başlayarak dizi üzerinde işlem yapar.
        System.out.println();
        arrayList.stream().sorted().skip(4).forEach(value -> System.out.print(value + " - "));

        // count dizideki eleman sayısını geri döndürür.
        System.out.println();
        long count = arrayList.stream().filter(value -> value < 30).distinct().count();
        System.out.println(count);

        // anyMatch metodu, dizideki bütün elemanları gezerek istenilen şartın yerine getirilip getirilmediğini kontrol eder. Bu metot akışı sonlandıran bir metottur,
        // yani bu metodu kullandıktan sonra akış üzerinde başka bir işlem yapamazsınız.
        boolean match = arrayList.stream().anyMatch(value -> value == 12);
        System.out.println("anyMatch Metodu Örneği -> " + match);
        boolean match1 = arrayList.stream().anyMatch(value -> value > 400);
        System.out.println("anyMatch Metodu Örneği -> " + match1);

        // allMatch metodu ise dizideki bütün elemanları gezerek her eleman için şartı yerine getirmesi halinde true, aksi takdirde false döndürecektir.
        boolean allMatchEx1 = arrayList.stream().allMatch(value -> value > -1);
        System.out.println("allMatch Metodu Örneği -> " + allMatchEx1);
        boolean allMatchEx2 = arrayList.stream().allMatch(value -> value > 1);
        System.out.println("allMatch Metodu Örneği -> " + allMatchEx2);

        // noneMatch metodu ise elemanların hiçbiri şartı yerine getirmiyorsa true, bir tanesi bile şartı yerine getiriyorsa false döndürür.
        boolean noneMatchEx1 = arrayList.stream().noneMatch(value -> value > -1);
        System.out.println("allMatch Metodu Örneği -> " + noneMatchEx1);
        boolean noneMatchEx2 = arrayList.stream().noneMatch(value -> value > 1);
        System.out.println("allMatch Metodu Örneği -> " + noneMatchEx2);

        // map Akışın elemanlarını değiştirmek için bu metodu kullanabilirsiniz. Function<T,R> türünde bir parametre alır ve bu fonksiyonu akışın bütün elemanlarına uygular.
        // Akışın yeni elemanları bu metottan dönen değerlerdir.
        arrayList.stream().distinct().sorted().map(value -> Math.pow(value, 2)).forEach(value -> {
            int val = value.intValue();
            System.out.print(val + " - ");});
    }
}
