# Encapsulation(Kapsülleme)
Sarmalama ilkesi, bir sınıfa ait değişkenlerin veya niteliklerin ancak o sınıfa ait metotlar tarafından değiştirilebilmesi ve okunabilmesi ilkesidir. Bu ilke sayesinde nesnelerde oluşacak anlamsızlıkların önüne geçilebilir.

Ayrıca değişkenlere sınıfların dışından erişim olmaması ve bir sınıf içindeki değişkenlerin nasıl ve ne kadar olacağının da başka kodlardan saklanmış olması anlamına gelir. Böylelikle biz değişkenlerimizi sarmalayarak istenmeyen durumlardan korunacak bir filtre haline dönüştürebiliriz.

Bu işlemleri yaparken GETTER ve SETTER metotlardan yararlanırız. Kısacası değişkenlerimizi PRIVATE olarak tanımlarız, GETTER ve SETTER metotları ile bu değişkenlerimizi korunaklı ve olumsuz durumlara karşı yazdığımız metotlarla görüntüleyebilir ve değiştirebiliriz. 