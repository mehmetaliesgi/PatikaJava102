package InputOutputOperations.OutputStreamWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        // OutputStreamWriter sınıfı, diğer çıktı akışlarıyla çalışır. Byte akışları ve karakter akışları arasında bir köprü olarak da bilinir.
        // Bunun nedeni, OutputStreamWriter'ın karakterlerini byte'a dönüştürmesidir.
        String data = "AŞAĞIDAKİ ÖRNEKLERİ ŞİRKETE GÖNDERELİM.";
        try {
            FileOutputStream outputStream = new FileOutputStream("src/InputOutputOperations/Files/OutputStreamWriter.txt");
            /* Bu şekilde de yapabiliyoruz fakat data değerimizdeki her bir karakteri yazabilmek için getBytes() metoduna ihtiyacımız var.
            outputStream.write(data.getBytes());
             */
            // Parametre olarak charset verilebilir. Default olarak UTF-8 verilir.
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
