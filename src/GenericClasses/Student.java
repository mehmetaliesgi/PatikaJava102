package GenericClasses;

public class Student <T> implements IDatabase <T>{
    @Override
    public boolean insert(T data) {
        System.out.println(data.getClass().getSimpleName());
        System.out.println("Veri eklendi!");
        return true;
    }

    @Override
    public boolean update(T data) {
        System.out.println(data.getClass().getSimpleName());
        System.out.println("Veri güncellendi!");
        return true;
    }

    @Override
    public boolean delete(T data) {
        System.out.println(data.getClass().getSimpleName());
        System.out.println("Veri silindi!");
        return true;
    }

    @Override
    public T select(T data) {
        System.out.println(data.getClass().getSimpleName());
        System.out.println("Veri Çekildi!");
        return null;
    }
}
