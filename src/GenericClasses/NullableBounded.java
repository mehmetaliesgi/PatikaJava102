package GenericClasses;

public class NullableBounded<T extends Number> {
    private T value;

    public NullableBounded(T value) {
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
