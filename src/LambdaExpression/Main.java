package LambdaExpression;

public class Main {
    public static void main(String[] args) {
        // Functional Interface: İçersinde sadece 1 tane abstract metodu bulunan interface'lere denir. Eğer ilgili interface'in türetildiği interface'de abstract metod varsa
        // bu durumda da functional interface olur. Functional interface'ler lambda expressionların kullanılabilmesi için tanımlanırlar.

        // @FunctionalInterface anotasyonu kullanılması zorunlu değildir. Bu anotasyon sadece validasyon yapmak amacıyla kullanılır. Eğer anotasyon eklenirse ve birden fazla
        // abstract metod eklenmeye çalışılırsa, bu durumda compile error verecektir.

        // Normalde yapılması gereken işlem bu şekilde
        IMatematik sum = new IMatematik() {
            @Override
            public void operations(int a, int b) {
                System.out.println(a + b);
            }
        };
        sum.operations(20, 43);

        // Java 8 ile gelen lambda expression kullanım kolaylığı sağladı ve kullanımı şu şekilde;
        IMatematik sumWithLambda = (int a, int b) ->System.out.println(a + b);
        sumWithLambda.operations(21, 44);

        // Veya;
        IMatematik plusWithLamda = (int a, int b) -> {
            System.out.println("Bu kod satırları lambda expression kullanılarak yazılmıştır.");
            int c = a * b;
            System.out.println("Sonnuç: " + c);
        };
        plusWithLamda.operations(23, 4);

    }
}
