package InputOutputOperations;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Dizin oluşturmak için kullanılan kod dizini. Eğer boluşturmak istediğimiz klasörün üst klasörü mevcut değilse mkdirs metodu kullanılabilir.
        File dizin = new File("src/InputOutputOperations/Files");
        dizin.mkdir();

        //File dosya = new File("src/InputOutputOperations/patika.txt");    dosya yolu belirtmek istersek parametreyi bu şekilde kullanabiliriz.
        File dosya = new File("src/InputOutputOperations/Files/patika.txt");    //ana dizinde işlem yapacaktır.

        // Dosyayı oluşturmak için gereken kod dizini
        try {
            if(dosya.createNewFile()) {
                System.out.println(dosya.getName() + " dosyası oluşturuldu.");
            } else {
                System.out.println(dosya.getName() + " dosyası zaten mevcut!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Dosyayı silmek için gereken kod dizini
        // dosya.delete();

        String[] files = dizin.list();
        for (String file : files) {
            System.out.println(file);
        }

    }
}
