# Dependency(Bağımlılık) / “uses a” İlişkisi
Java'da Bağımlılık bir diğer adı ile "uses a" ilişkisi, eğer bir sınıfın metotlarından en az biri başka bir sınıfa ait bir parametre alıyorsa, parametre alan metoda ait sınıf diğeri sınıfa bağımlıdır ya da onu kullanır (uses) denir. Yazılan program da sınıflar arası bağımlılığı arttırmak, birlikte yönetilmesi gereken sınıf miktarının da artmasına sebep olur. Bu durumda programın yönetilebilirliği veya bakımı zorlaşacaktır. Bunun sebebi ise, bir sınıf içinde yapılacak herhangi bir değişiklik bağımlı olduğu sınıfları da etkileyecektir ve bakım yükü artacaktır.

Yaptığımız örnekte ise Course sınıfı Student sınıfına bağımlıdır. Çünkü Course sınıfımızda oluşturduğumuz calculateAvarage metodu Student parametresi beklemektedir.

# Birleştirme (Composition) / "has a" İlişkisi

Java'da Birleştirme (Composition) ilişkisi , eğer bir sınıfın değişkenlerinden en az bir tanesi başka bir sınıf türünden ise, değişkene sahip olan sınıf diğer sınıfı içerir yani "has a" olarak adlandırılır.