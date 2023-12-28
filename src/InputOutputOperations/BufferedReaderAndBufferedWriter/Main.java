package InputOutputOperations.BufferedReaderAndBufferedWriter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // BufferedReader, 8192 karakterlik bir dahili arabellek tutar. BufferedReader'daki okuma işlemi sırasında diskten bir yığın karakter okunur
        // ve dahili tamponda saklanır ve dahili tampondan karakterler ayrı ayrı okunur. Böylelikle diskle iletişim sayısı azalır ve daha hızlı işlem yapar.
        // Dosya okuma yazmak için en çok kullanılan sınıftır.
        try {
            /*
            FileReader fileReader = new FileReader("src/InputOutputOperations/Files/BufferedReader.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }


            // BufferedReader sınıfı dosyadaki veriyi karakter karakter okumak yerinde satır satır okuma işleminide gerçekleştirebilir.
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
            */

            String data = "\n\nYaptığın hatalar kadar büyük olmadın bana anlatma.\nKonuştukların kadar küçük olmadın, mini minnacık.\nBilirler her şeyi doğru ama niye yürüyüp durular eğri.\nÇık şu işin içinden çık şimdi.";

            FileWriter fileWriter = new FileWriter("src/InputOutputOperations/Files/BufferedReader.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);

            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
