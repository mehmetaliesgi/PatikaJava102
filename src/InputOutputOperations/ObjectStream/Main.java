package InputOutputOperations.ObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Audi", "A6");

        try {
            /*FileOutputStream fileOutputStream = new FileOutputStream("src\\InputOutputOperations\\Files\\araba.txt");
            // Bir nesneyi bu metotlarla bir dosya içine kaydetmemize olanak sağlar. Oluşan nesnenin sınıfının Serializable interface'ini implemente etmesi gerekmektedir.
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(car);
            outputStream.close();
             */

            FileInputStream fileInputStream = new FileInputStream("src\\\\InputOutputOperations\\\\Files\\\\araba.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Car newCar = (Car) inputStream.readObject();
            System.out.println(newCar.getBrand() + "\n" + newCar.getModel());
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
