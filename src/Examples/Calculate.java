package Examples;

public class Calculate <T extends Number>{
    private T value1;
    private T value2;

    public Calculate(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }
}
