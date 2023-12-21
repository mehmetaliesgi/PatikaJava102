package InputOutputOperations.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            /* Dosyamız mevcut değilse ilk önce dosya oluşturup daha sonra bu dosyayı FileInputStream nesnesine parametre olarak verebiliriz.
            File dosya = new File("src/InputOutputOperations/Files/patika.txt");
            dosya.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(dosya);
             */

            // Dosyamız mevcut ise bu şekilde kullanabiliriz.
            FileInputStream fileInputStream = new FileInputStream("src/InputOutputOperations/Files/patika.txt");

            // Dosyamızdaki kullanılabilir byte sayısını available() metodu geri döndürür.
            System.out.println("Kullanılabilir Byte sayısı: " + fileInputStream.available());

            // Dosyamızdaki belirli karakterleri atlammak belirli bir indexten başlamak için skip() metodunu kullanabiliriz.
            fileInputStream.skip(10);

            // Dosyadan byte okuma işleme için read() metodunu kullanıyoruz. Burada read metodu karakterin ASCII kodunu döndürür. Bu sebeple char casting yapılmalıdır.
            // Eğer read metodu okuyacak karakter bulamazsa -1 değerini geri döndürür.
            int i = fileInputStream.read();
            while (i != -1) {
                System.out.print((char)i);
                i = fileInputStream.read();
            }
            // İşi bittikten sonra hafızada yer kaplamamısı için close metodunu kullanıyoruz.
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
