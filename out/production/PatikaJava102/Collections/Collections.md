# COLLECTIONS NEDIR?

Java Collections (Koleksiyonlar), nesne grubunu depolamak veya işlem yapma gibi işlemleri sağlayan bir türdür. Şöyle düşünelim, program geliştirirken bir değişken içerisinde birden fazla eleman tutmak isteyebiliriz. Bunun gibi durumlarda Java Collections (Koleksiyonlar) sınıfını kullanmak bizim için en verimli seçenek olacaktır. Genel itibariyle Set, List ve Map olmak üzere 3 temel türden oluşmaktadır. Bunlara Collection Framework denmektedir.
Java’da Collections (Koleksiyonlar) ne işe yarar nerelerde kullanırız dersek. Java Collections (Koleksiyonlar) veri depolamak, veri silmek, veri ekleme ve depolanan verileri içerisinde veri aramak gibi işlemler için kullanılırlar. Bu gibi işlemler Java’da Diziler ile de yapılabilir ama Collections ile daha hızlı ve daha kolay bir şekilde yapıldığı için Collections kullanımı tercih edilir.

 - **Set Nesnesi:** Kendisine verilen elemanların her birinde sadece bir tanesini tutar. Kopya ya da
tekrarlanan elemanları barındırmaz.
 - **List Nesnesi:** Kendisine verilen elemanları sıralı şekilde tutar. Tekrarlana elemanları barındırabilir.
 - **Map Nesnesi:** Her biri birbirinden farklı anahtarlar ile eşleştirilen nesnelerden oluşur.

## SET
Set interface'inde kullanabileceğimiz 3 adet yapı mevcuttur. Bunlar;

1. HashSet
2. LinkedHashSet
3. TreeSet

### 1. HashSet
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

### 2. LinkedHashSet

LinkedHashSet normal HashSet'ten farklı olarak giren değer sırası ile çıktı sırası aynıdır. Yani FIFO kuralına uyum sağlar. Yine HashSet'te olduğu gibi tekrar eden değerler bulundurmaz.
Tanımlanması aşağıdaki gibidir;

    LinkedHashSet<Integer> lSet = new LinkedHashSet<>();

Tanımlanma şekli yukarıdaki gibidir ve HashSet için kullandığımız hangi hazır method var ise bu yapı içinde aynı metodları kullanabiliriz.


### 3. TreeSet

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


## LIST
List Interface, Java'nın java.util paketinde yer alan bir arabirimdir ve sıralı koleksiyonları temsil eder. Bu arabirim, Java koleksiyon çerçevesinin bir parçasıdır ve birçok farklı liste türünü temsil etmek için kullanılır. List, aşağıdaki temel özellikleri sunar:

1. **Sıralı Elemanlar:** List, eklenen elemanların sıralı bir şekilde saklandığı bir koleksiyon yapısıdır. Yani elemanlar eklenme sırasına göre tutulur ve belirli bir sıra numarasına (indeks) sahiptirler.
2. **Duplications (Çoğaltmalar):** List, aynı elemanın birden fazla kez koleksiyona eklenmesine izin verir. Yani bir List içinde aynı elemanı birden fazla kez bulabilirsiniz.
3. **Indeksleme:** Elemanlara indeks numaralarıyla erişilebilir. Bu, belirli bir elemanı hızlıca bulmayı ve değiştirmeyi sağlar.

Java’da List arabirimini uygulayan birkaç sınıf vardır, en yaygın olanları şunlardır:

1. **ArrayList:** Dinamik bir dizi yapısını temsil eder ve elemanları bir dizide saklar. Elemanların indeksleme işlemi hızlıdır.
2. **LinkedList:** Bağlantılı liste yapısını temsil eder ve elemanları çift yönlü bağlantılı düğümler aracılığıyla saklar. Elemanların eklenmesi ve çıkarılması hızlıdır.
3. **Vector:** Dinamik bir dizi yapısını temsil eder, ancak senkronize edilmiştir, bu nedenle çoklu işlem ortamlarında kullanılabilir.

`List` arabirimini kullanarak, sıralı verileri kolayca işleyebilir ve yönetebilirsiniz. Bu, veritabanı sonuçları, kullanıcıların girdileri ve daha pek çok senaryoda kullanışlıdır.

### 1. ArrayList
Java’da ArrayList, java.util paketinde bulunan ve dinamik bir dizi (dynamic array) yapısını temsil eden bir sınıftır. ArrayList, Java koleksiyon çerçevesinin bir parçasıdır ve List arabirimini uygular. ArrayList'in temel özellikleri:

1. **Dinamik Dizi Yapısı:** ArrayList, dinamik bir dizi yapısını temsil eder. Bu, ArrayList'in boyutunu otomatik olarak ayarlayabilmesi ve elemanların eklenmesi veya çıkarılması durumunda dinamik olarak büyüyebilmesi anlamına gelir. Yani boyutu sabit değildir.
2. **Sıralı Elemanlar:** Elemanlar, eklenme sırasına göre saklanır ve bir indeks numarası ile erişilebilirler. Bu, verileri sıralı bir şekilde tutmanızı sağlar.
3. **Duplications (Çoğaltmalar):** ArrayList, aynı elemanın birden fazla kez koleksiyona eklenmesine izin verir. Yani aynı elemanı birden fazla kez ekleyebilirsiniz.
4. **Hızlı Indeksleme:** Elemanlara indeks numaralarıyla hızlıca erişebilirsiniz. Bu, belirli bir elemanı hızlıca bulmayı ve değiştirmeyi sağlar.
5. **Genel Kullanım:** ArrayList, genel kullanıma uygun bir veri yapısıdır ve birçok farklı veri türünü saklayabilirsiniz (örneğin, String, Integer, benzeri nesneler).

Şu şekilde tanımlanır:
    
    List<Integer> liste = new ArrayList<>();

ArrayList sınıfının bazı temel metotları şunlardır:

- **add(E element):** Belirtilen elemanı ArrayList'e ekler.
- **remove(int index):** Belirtilen indeksteki elemanı kaldırır.
- **get(int index):** Belirtilen indeksteki elemanı döndürür.
- **size():** Listenin boyutunu (eleman sayısını) döndürür.
- **isEmpty():** Liste boşsa true, doluysa false döndürür.
- **clear():** Listeyi temizler, yani tüm elemanları kaldırır.

### 2. LinkedList
Java’da LinkedList sınıfı, java.util paketinde bulunan ve bağlantılı liste (linked list) yapısını temsil eden bir sınıftır. LinkedList, Java koleksiyon çerçevesinin bir parçasıdır ve List arabirimini uygular.
LinkedList sınıfı, elemanları çift yönlü bağlantılı düğümler (nodes) aracılığıyla saklar. Her düğüm, bir veri elemanı ve bir sonraki düğümün referansını içerir. Bu yapı, **elemanların eklenmesi ve çıkarılması işlemlerini hızlı yapmayı** sağlar.

LinkedList sınıfının temel özellikleri şunlardır:
1. **Çift Yönlü Bağlantı:** Her düğüm, hem bir sonraki düğümün hem de bir önceki düğümün referansını içerir. Bu, düğümler arasında ileri ve geri gezinmeyi kolaylaştırır.
2. **Dinamik Boyut:** LinkedList, boyutu otomatik olarak ayarlayabilen bir veri yapısıdır. Elemanlar eklenip çıkarıldıkça dinamik olarak büyüyebilir.
3. **Sıralı Elemanlar:** Elemanlar, eklenme sırasına göre saklanır ve indeks numarası ile erişilebilirler. Bu, verilerin sıralı bir şekilde tutulmasını sağlar.
4. **Duplications (Çoğaltmalar):** LinkedList, aynı elemanın birden fazla kez koleksiyona eklenmesine izin verir.
5. **Bağlantılı Liste Mantığı:** Elemanların eklenmesi ve çıkarılması, düğümler arasındaki referansların güncellenmesiyle gerçekleşir. Bu, ekleme ve çıkarma işlemlerinin hızlı olmasını sağlar.

Şu şekilde tanımlama yapılır:

    LinkedList<String> linkedList = new LinkedList<>();

LinkedList sınıfının bazı temel metotları şunlardır:

- **add(E element):** Belirtilen elemanı LinkedList'e ekler.
- **remove(int index):** Belirtilen indeksteki elemanı kaldırır.
- **get(int index):** Belirtilen indeksteki elemanı döndürür.
- **size():** Listenin boyutunu (eleman sayısını) döndürür.
- **isEmpty():** Liste boşsa true, doluysa false döndürür.
- **clear():** Listeyi temizler, yani tüm elemanları kaldırır.

#### NOT: `LinkedList` sınıfı, özellikle elemanların eklenmesi ve çıkarılmasının sıkça yapıldığı senaryolarda kullanışlıdır. Ancak indeksleme işlemi, doğrudan elemanların indeks numarasına erişimi desteklemediği için `ArrayList` gibi sıralı erişim gerektiren durumlarda daha hızlıdır.

### 3. Vector
Java’da Vector sınıfı, java.util paketinde bulunan ve bir dinamik dizi (dynamic array) yapısını temsil eden bir sınıftır. Vector, Java koleksiyon çerçevesinin bir parçasıdır ve List arabirimini uygular. Ancak ArrayList gibi değil, Vector birçok işlemi senkronize bir şekilde yönetir, bu da çoklu işlem (multithreading) ortamlarında kullanılabilir olmasını sağlar.

Vector sınıfının temel özellikleri şunlardır:

1. **Dinamik Dizi Yapısı:** Vector, dinamik bir dizi yapısıdır. Yani boyutu otomatik olarak ayarlayabilmesi ve elemanlar eklenip çıkarıldıkça dinamik olarak büyüyebilmesi anlamına gelir.
2. **Sıralı Elemanlar:** Elemanlar, eklenme sırasına göre saklanır ve bir indeks numarası ile erişilebilirler. Bu, verilerin sıralı bir şekilde tutulmasını sağlar.
3. **Duplications (Çoğaltmalar):** Vector, aynı elemanın birden fazla kez koleksiyona eklenmesine izin verir. Yani aynı elemanı birden fazla kez ekleyebilirsiniz.
4. **Senkronizasyon:** Vector sınıfı, işlemlerin senkronize (thread-safe) bir şekilde gerçekleştirilmesini sağlar. Bu, çoklu işlem ortamlarında kullanılabilirliğini artırır.

Şu şekilde tanımlama yapılır:

    Vector<Integer> vc = new Vector<>();

Yine listlerde kullanılan metodları vectorler içinde kullanabilirsiniz.

Vector sınıfı, Java'nın eski koleksiyon yapısıdır ve özellikle çoklu işlem ortamlarında kullanılması gerektiğinde tercih edilir. Ancak yeni Java koleksiyon çerçevesinde daha modern alternatifler (örneğin, ArrayList veya LinkedList) mevcuttur ve performans açısından daha iyi sonuçlar verebilir. Dolayısıyla, yeni projelerde Vector kullanmak yerine bu modern alternatiflere yönelmek genellikle daha iyi bir seçenektir.

## QUEUE
Queue arayüzü java.util paketinde bulunur ve Collection arayüzünü genişletir, FIFO (İlk Giren İlk Çıkar) sırasına göre işlenmek üzere olan öğeleri tutmak için kullanılır. Kullanımı listenin sonuna eleman eklemek ve listenin başından eleman silmekle sınırlı olan nesnelerin sıralı bir listesidir (yani), FIFO veya İlk Giren İlk Çıkar ilkesini izler.
Bir interface olan Queue'larda nesne oluşturabilmek ve veri saklayabilmek için **LinkedList Class'ı** ve **PriorityQueue Class'ından** yararlanır.

### 1. Queue LinkedList
Queue arayüzü Java Collections Framework ‘un bir üyesidir. İşlemlerden geçmeden önce öğeleri depolanmasını sağlar. Collection arayüzünün bir altarayüzü olduğundan, onun bütün metotlarını kullanır. Onlara ek olarak, kuyruk yapısındaki ekleme, silme gibi işlemleri kolaylaştıran metotlara sahiptir.

Ortaya çıkış nedeniyle, Queue bir FIFO (first-in-first-out, ilk giren ilk çıkar) yapısıdır. Ancak, Queue ve Collection arayüzündeki metotlar kullanılarak, FIFO yapısı LIFO (last-input-first-output, son giren ilk çıkar) yapısı gibi kullanılabilir. **FIFO** ve **LIFO** yapılarına öncelik sıralamalı kuyruklar (priority queues) denilir.

Genel metodları:

- **element():** Kuyruğun başındaki öğeyi verir, ama onu kuyruktan atmaz.
- **add(eleman):** Parametrede verilen elemanı kuyruğa ekler. İşlemin başarısız olması durumunda hata fırlatır.
- **offer(eleman):** Parametrede verilen elemanı kuyruğa ekler. İşlemin başarısız olması durumunda null döner.
- **poll():** Kuyruğun başındaki elemanı kuyruktan çıkartır.
- **peek():** Kuyrukta sıradaki elemana ulaşmak için kullanılır.
- **remove():** Kuyruktaki belirli bir indisteki belirli bir değeri siler. Fakat sadece **OBJE** parametresi alır.

Tabi yukarıdaki metodlardan daha fazlası mevcuttur.

Tanımlanma şekli: 
    
    Queue<String> qList = new LinkedList<>();

### 2.PriorityQueue
Queue LinkedListten tek farkı kendi sıralama yöntemlerimizi yazabiliriz.

Tanımlanma şekli:

    PriorityQueue<String> qList = new PriorityQueue<>(Sıralama işlemi); 

Küçük bir örnek yaparak daha iyi anlaşılır kılalım.

