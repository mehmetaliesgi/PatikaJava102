package InputOutputOperations.FileReaderAndFileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            // FileReader sınıfı, dosyadan verileri (karakter olarak) okumak için kullanılabilir. InputStreamReader sınıfı genişletir.
            /* Bu sınıftan nesne oluştururken yine charset default olarak UTF-8 verilir. Biz istersek farklı charsetleri Charset sınıfındaki forName metodu kullanılır.
            FileReader fileReader = new FileReader("src/InputOutputOperations/Files/FileReader.txt");
            int i = fileReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fileReader.read();
            }

            fileReader.close();
             */

            String data = "\nBu datayı FileWriter sınıfından nesne üretilerek dosyaya yazılmıştır.";
            FileWriter fileWriter = new FileWriter("src/InputOutputOperations/Files/FileReader.txt", true);
            fileWriter.write(data);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
