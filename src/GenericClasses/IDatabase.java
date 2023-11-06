package GenericClasses;

public interface IDatabase <T> {
    boolean insert(T data);
    boolean update(T data);
    boolean delete(T data);
    T select(T data);
}
