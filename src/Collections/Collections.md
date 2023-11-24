# COLLECTIONS NEDIR?

Java Collections (Koleksiyonlar), nesne grubunu depolamak veya işlem yapma gibi işlemleri sağlayan bir türdür. Şöyle düşünelim, program geliştirirken bir değişken içerisinde birden fazla eleman tutmak isteyebiliriz. Bunun gibi durumlarda Java Collections (Koleksiyonlar) sınıfını kullanmak bizim için en verimli seçenek olacaktır. Genel itibariyle Set, List ve Map olmak üzere 3 temel türden oluşmaktadır. Bunlara Collection Framework denmektedir.
Java’da Collections (Koleksiyonlar) ne işe yarar nerelerde kullanırız dersek. Java Collections (Koleksiyonlar) veri depolamak, veri silmek, veri ekleme ve depolanan verileri içerisinde veri aramak gibi işlemler için kullanılırlar. Bu gibi işlemler Java’da Diziler ile de yapılabilir ama Collections ile daha hızlı ve daha kolay bir şekilde yapıldığı için Collections kullanımı tercih edilir.

 - Set Nesnesi: Kendisine verilen elemanların her birinde sadece bir tanesini tutar. Kopya ya da
tekrarlanan elemanları barındırmaz.
 - List Nesnesi: Kendisine verilen elemanları sıralı şekilde tutar. Tekrarlana elemanları barındırabilir.
 - Map Nesnesi: Her biri birbirinden farklı anahtarlar ile eşleştirilen nesnelerden oluşur.

## Set
Set interface'inde kullanabileceğimiz 3 adet yapı mevcuttur. Bunlar;

- HashSet
- LinkedHashSet
- TreeSet

Yukarıda Set nesnesinin tanımını yapmıştık. Bu sebeple HashSet'ten başlayarak tanımlanma şekillerini inceleyelim.

    HashSet<WrapperClass> hashName = new HashSet<>();
    HashSet<Integer> hashCountry = new HashSet<>();

Burada bu yapıların kullanılmasındaki en büyük avantajlardan birinin eleman eklendikçe genişleyen yapıda olduklarını bilmektir. Yukarıdaki örnekte hashCountry nesnesinin içersine istediğimiz kadar eleman ekleyebiliriz. Tabi tekrar eden elemanları sadece 1 kere kaydedecektir. Şöyle düşünebilirsiniz neden bu değerleri bir array'de tutmadık. Sebebi az önce söylediğimiz eleman ekledikçe genişleyen bir yapıda olmasından dolayı. Bir array tanımlarken sabit bir alan
tanımladığımızı biliyorsunuz. Fakat diyelim ki ihtiyacınıza göre 10 elemanlı bir dizi oluşturdunuz ve 11. elemanı eklemek durumunda kaldınız. Ne yapacaksınız? Yeni bir array oluşturup, eski arraydaki değerleri buraya taşıdıktan sonra yeni elemanı ekleme işlemini yapacaksınız. Bu karmaşıklıktan kurtulmak için Collection sınıfındaki nesneler kullanılmaktadır.
Ayrıca HashSetlerde FIFO vey LIFO kuralı geçerli değildir. Yani elemanları belirli bir sıraya göre eklediniz fakat çıktıda aynı sıraya göre gelecek diye bir garanti yok. Rastgele olarak size çıktıları verecektir.

HashSet'te kullandığımız genel metodlar;

- add -> Nesnemize veri ekleme işlemini gerçekleştirir.
 

    hashCountry.add("Türkiye");
    hashCountry.add("Germany");
    hashCountry.add("USA");
    hashCountry.add(null);

- size -> Nesnemizin içersinde bulunan eleman sayısını geri döndürür.

    
    hashCountry.size();

- isEmpty -> Nesnemizin içerisinin boş olup olmadığını boolean bir değer olarak geri döndürür.


    hashCountry.isEmpty();


- contains -> Nesnemizin içerisinde parametre olarak verdiğimiz değerin bulunup bulunmadığını boolean bir değer olarak geri döndürür.


    hashCountry.contains("Türkiye");


- remove -> Nesnemizde bulunan bir değeri silme işlemimizi yapar. Boolean bir değer olarak geri dönüş sağlar.


    hashCountry.remove("Germany");


- clear -> Bu metod nesnemizin içindeki bütün elemanları temizler.


    hashCountry.clear();


Şimdi nesnemizin içerisindeki elemanları gezme işlemini nasıl yapacağız konusuna gelelim. Bunun için Iterator sınıfından bizim hashSet'imizi tanımladığımız şekilde bir iterator nesnesi tanımlayacağız. Daha sonra bu iterator nesnesi ile hashMap nesnemizi eşitleyeeğiz ve hashSet sınıfımızda bulunan iterator() metodunu kullanacağız.

    Iterator<String> itr = hashCountry.iterator();

Yukarıdaki gibi tanımlamamızı yaptıktan sonra kullanacağımız iki önemli metod bulunuyor. hasNext() ve next() metodu. Çalışma mantığı olarak itr nesnesi elemanlarımızın bulunduğu hafıza biriminden önceki hafıza birimine yerleşir ve daha sonra hasNext() metodu ile kendinden sonraki
hafıza birimi boş mu diye kontrol eder. Eğer var ise next() metodu ile oraya geçer ve elemanı yazdırır. Aynı şekilde işlemler devam eder. Ta ki son elemanın bulunduğu hafıza birimine gidip daha sonraki hafıza biriminin boş olduğunu görene kadar. Tabi bu işlemin devamlılığını ise while 
döngüsü ile yaparız.

    while(itr.hasNext()){
        System.out.println(itr.next());
    }

Yukarıdaki kod satırı cümlelerimizi daha anlamlı kılmıştır umarım.

