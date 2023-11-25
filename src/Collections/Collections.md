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

### - HashSet
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

### - LinkedHashSet

LinkedHashSet normal HashSet'ten farklı olarak giren değer sırası ile çıktı sırası aynıdır. Yani FIFO kuralına uyum sağlar. Yine HashSet'te olduğu gibi tekrar eden değerler bulundurmaz.
Tanımlanması aşağıdaki gibidir;

    LinkedHashSet<Integer> lSet = new LinkedHashSet<>();

Tanımlanma şekli yukarıdaki gibidir ve HashSet için kullandığımız hangi hazır method var ise bu yapı içinde aynı metodları kullanabiliriz.


### - TreeSet

Yine TreeSet içinde tekrarlanan öğeleri içermediğini söyleyebiliriz. Burada TreeSet'i diğer Set metodlarında ayıran özellik ise Comparator interface'ini implemente etmesi ve istediğimiz bir veriye göre sıralama yapabilmemize olanak sağlamasıdır.
Tanımlanma şekli diğerleri gibi aynıdır fakat parametre olarak bir sıralama şekli alırlar. Örnek olarak koda dökeceğiz. Burada sadece tanım olarak geçelim. Yine aynı metodlara ek olarak bir kaç farklı hazır metod kullanılabilir. Araştırabilirsiniz.

    TreeSet<Student> students = new TreeSet<>();

Bu tanımlamada bizden bir karşılaştırma şekli istediği için hata alacaktır. Bunu önlemek için bir karşılaştırma sınıfı üretip, bu sınıftan nesne ürettikten sonra parametre olarak göndermeliyiz.
Bu sıralama işlemini yaparken compare metodunun nasıl çalıştığını açıklayalım. Sıralama işlemini yapacak olan sınıfı tanımladık ve Comparator interface'inden implemente ettik ve compare metodunu override ettik.

Burada bu metod 2 adet nesne alacak ve geri dönüş olarak integer bir değer verecektir. Eğer;

 - Geri dönen değer negatif ise birinci parametre küçüktür ikinci parametre olarak işlem yapar.
 - Geri dönen değer pozitif ise birinci parametre büyüktür ikinci parametre olarak işlem yapar.
 - Geri dönen değer sıfır ise değerler eşittir.

Buna ek olarak reversed metodunu kullanarak büyükten küçüğe veya küçükten büyüğe sıralanmış değerlerin tersi şekilde sıralanmasını sağlayabilirsiniz. 

Yukarıda sadece aritmetik işlemlerden bahsettik. Peki non-aritmetik işlemler yani string değerli değerleri işleme alırsak ne yapacağız?
Bunun için ise tanımlanmış özel compareTo metodu vardır. Yine Comparator inteface'ini implemente edeceğiz ve compare metodunu override edeceğiz. Fakat bu sefer o1 ve o2 nesnelerimizin string değerlerini alacağız ki bizim örneğimizde;

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

Şeklinde olacaktır. Tersini almak için yine reserved metodunu kullanabiliriz.
