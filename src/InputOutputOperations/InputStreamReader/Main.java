package InputOutputOperations.InputStreamReader;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        // Byte cinsinden verileri karakter cinsinden verilere dönüştürmek için kullanılabilir. Özel karakterlerin(ç, Ö, ş, ..) karakter seti belirleyerek
        // doğru çıktılar alamamıza olanak sağlar.

        try {
            /* Bu şekilde dosyadan dataları okursak daha önceden gördüğümüz gibi Türkçe karakterler bozuk çıkıyor.
            FileOutputStream outputStream = new FileOutputStream("src/InputOutputOperations/Files/InputStreamReader.txt", true);
            PrintStream printStream = new PrintStream(outputStream);
            printStream.print("JAVA 102 PATİKA ÖĞRENİYORUM!!");

            FileInputStream inputStream = new FileInputStream("src/InputOutputOperations/Files/InputStreamReader.txt");
            int i = inputStream.read();
            while (i != -1) {
                System.out.print((char)i);
                i = inputStream.read();
            }
            */

            FileInputStream inputStream = new FileInputStream("src/InputOutputOperations/Files/InputStreamReader.txt");

            // Charset classından forName metodu ile parametre olarak charset verillebilir. Parametre vermezsek default olarak UTF-8 verilecektir zaten.
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            int i = inputStreamReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = inputStreamReader.read();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
