package InputOutputOperations.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        String data = "Output Stream Örneği\nPatika Dev";
        try {
            // Eğer ikinci parametre true olarak girilirse her seferinde yeni dosya oluşturmadan var olan dosyanın üzerine yazma işlemini gerçekleştirir.
            FileOutputStream outputStream = new FileOutputStream("src/InputOutputOperations/Files/FileOutputFile.text", true);
            // Dosyadan okuma işlemini nasıl byte byte yapıyorsak, dosyaya yazma işleminde de byte byte yapıyoruz. Bunun için getDytes() metotu kullanılır.
            byte[] dataByte = data.getBytes();
            // Dosyaya yazma işlemi için write() metodu kullanılır ve parametre olarak byte byte ayırdığımız datayı yollarız.
            outputStream.write(dataByte);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
