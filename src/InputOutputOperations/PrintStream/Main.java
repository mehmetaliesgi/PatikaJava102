package InputOutputOperations.PrintStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        // Print stream sınıfı, çıktı verilerini byte yerine yaygın olarak okunabilir biçimde(metin) yazmak için kullanılabilir.
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/InputOutputOperations/Files/PrintStream.txt", true);
            PrintStream output = new PrintStream(fileOutputStream);
            output.print("String " + 12345);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
