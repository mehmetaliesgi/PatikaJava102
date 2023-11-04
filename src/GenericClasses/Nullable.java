package GenericClasses;

public class Nullable <T>{
    private T value;

    public Nullable(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isNull() {
        return getValue() == null;
    }

    @Override
    public String toString() {
        if (isNull()) {
            return "Verilen değer null";
        }
        return "Verilen değer " + getValue();
    }
}
