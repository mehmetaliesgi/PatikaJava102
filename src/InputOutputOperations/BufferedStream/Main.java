package InputOutputOperations.BufferedStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            /* BufferedStream classı daha büyük verilerde daha iyi performans sağlar.
            FileInputStream fileInputStream = new FileInputStream("src/InputOutputOperations/Files/BufferedStream.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            int i = bufferedInputStream.read();
            while (i != -1) {
                System.out.print((char)i);
                i = bufferedInputStream.read();
            }
            fileInputStream.close();
            bufferedInputStream.close();

            */
            String text = "\nBu bir deneme BufferedOutputStream ornegidir.";

            FileOutputStream fileOutputStream = new FileOutputStream("src/InputOutputOperations/Files/BufferedStream.txt", true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = text.getBytes();
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
