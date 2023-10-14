# Interface Nedir?

Interface, Java tarafından geliştirilmiş, class’lardan farklı bir yapıya sahip olan yapılardır. Interface’lar, tıpkı abstract class’larda olduğu gibi soyut yani body’si olmayan metodlar oluşturmaya imkan tanır. Bu metodlar, ilgili interface’e extend edilen class’lar tarafından override edilip kullanılmak zorundadır.

Peki abstract class’lar varken, Java neden Interface gibi bir yapı oluşturmuştur? Bunun en temel nedeni, class’ların multiple intheritance’ı desteklememesidir. Abstract da bir class olduğu için multiple intheritance’ı desteklemez. Yani bir class’ın yalnızca bir parent’ı olabilir. Bir class birden fazla class’ın alt sınıfı olamaz.

Bu sınırlama, bazı dezavantajlarla birlikte gelmektedir. Örnek vermek interface’ler olmasa, çok büyük çapta bir projede, ürünün sahip olacağı tüm temel fonksiyonları tek bir class’a toplamak gerekecekti. Bu, hem çok uzun kod yapılarının oluşmasına hem de büyük bir karmaşıklığa sebep olacaktı.

İnterface’lerle birlikte bu zorluk ortadan kalktı. Java, Interface yapısını oluşturarak, bir class’ın birden fazla sayıda interface’in alt sınıfı haline gelmesini mümkün hale getirdi. Böylelikle, çok sayıda sınıf tarafından kullanılması gereken temel özellikler, farklı interface’ler içerisine eklenebildi. Ve class’lar birden fazla interface’e ‘implement’ edilerek, bu metodları override ederek kullanabilir hale geldiler.

# - Interface Özellikleri
Class’lardan farklı bir yapıya sahip olan interface’leri, farklı özellikleri vardır. Bu özellikleri şu şekilde sıralayabiliriz.

 - Interface tam abstraction olarak nitelenirler. Bu sebeple içine abstract olmayan metotlar eklenmez.
 - Interface’ler tam abstraction oldukları için, oluşturulan metotlara abstract kelimesini iliştirmeye gerek yoktur.
 - Interface içerisinde oluşturulan metodlar varsayılan olarak public’tir. Yani metod oluştururken public kelimesini kullanmaya gerek yoktur.
 - Bir class’ı bir interface’in alt sınıfı yapmak için ‘extends’ değil, ‘implements’ kelimesi kullanılır.
 - Bir class, birden fazla sayıda interface’e implement edilebilir.  
 - Bir interface birden fazla sayıda interface’e extend edilebilir.
 - Bir class, bir interface’in parent’ı olamaz.
 - Bir interface’in içerisinde instant variable oluşturulamaz.
 - Bir interface’in içinde oluşturulan her variable final ve static olmak zorundadır. Bu varsayılan olarak bu şekilde gelir.
 - Bir class, implement edildiği interface içerisindeki tüm metodları override etmek zorundadır. Aksi halde, o class’ın abstract class olması gerekir.