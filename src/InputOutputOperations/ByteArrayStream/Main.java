package InputOutputOperations.ByteArrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /* Byte Array Input Stream

        String data = "JAVA 102 Derslerinden olan Byte Array Stream classini inceliyoruz.";
        byte[] dataByteArray = data.getBytes();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataByteArray);
        // Burada arrayı parçalayabilirsiniz. Burada 1. indis ile 51. indis arasında kalan dataları alacaktır.
        // ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataByteArray, 1, 51);

        System.out.println("Kullanılabilen byte sayısı: " + byteArrayInputStream.available());

        int i = byteArrayInputStream.read();
        while (i != -1) {
            System.out.print(" " + (char)i);
            i = byteArrayInputStream.read();
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
         */


        // Byte Output Stream
        String data = "Java 102 Dersleri!";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] dataArray = data.getBytes();

        try {
            byteArrayOutputStream.write(dataArray);
            String newData = byteArrayOutputStream.toString();
            System.out.println("Tekrar birleştirilmiş data: " + newData);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
