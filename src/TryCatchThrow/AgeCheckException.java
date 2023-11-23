package TryCatchThrow;

public class AgeCheckException extends Exception{

    public AgeCheckException(String message) {
        super(message);
        System.out.println("Yaş hatası alındı! Bu işlem AgeCheckException sınıfında yapıldı.");
    }
}
