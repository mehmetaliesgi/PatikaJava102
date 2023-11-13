package GenericClasses.Odev;

public class ArrayOperations <T> {
    int capacity;
    T[] list;
    T[] listTemp;
    int itemCount = 0;

    public ArrayOperations() {
        this.capacity = 10;
        this.list = (T[]) new Object[this.capacity];
    }
    public ArrayOperations(int capacity) {
        this.capacity = capacity;
        this.list = (T[]) new Object[this.capacity];
    }

    public int size() {
        return this.itemCount;
    }

    public int getCapacity() {
        return this.list.length;
    }

    public void addData(T data) {
        if (this.size() < this.capacity) {
            list[this.itemCount] = data;
            this.itemCount++;
        } else {
            this.capacity = this.capacity * 2;
            this.updateCapacity();
            this.addData(data);
        }
    }

    public void updateCapacity() {
        this.listTemp = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.list.length; i++) {
            this.listTemp[i] = this.list[i];
        }
        this.list = this.listTemp;
    }

    public T get(int indexNum) {
        if (indexNum > this.itemCount) {
            return null;
        }
        else {
            return list[indexNum];
        }
    }

    public void set(int indexNum, T value) {
        if (indexNum > this.capacity) {
            System.out.println("Lütfen dizinin alabileceği değerler aralığında bir değer girin."
            + " Girebileceğiniz maksimum değer: " + (this.capacity - 1));
        }
        else {
            if (list[indexNum] == null){
                itemCount++;
                list[indexNum] = value;
            }
            else {
                list[indexNum] = value;
            }
           /* for (T i : list) {
                System.out.print(i + " - ");
            }*/
        }
    }

    public void remove(int indexNum) {
        if (indexNum < 0) {
            System.out.println("Index değeriniz eksi bir değer olamaz!!!");
        }
        else if ( indexNum > this.itemCount) {
            System.out.println("Index değeriniz dizide bulunan eleman sayısını aşıyor");
        }
        else {
            removeToList(indexNum);
            System.out.println(indexNum + ". eleman silindi.");
            this.itemCount--;
        }
    }

    public void removeToList(int indexNum) {
        T[] tempListArr = this.list;
        /*System.out.println("Temp Lİst****************************************");
        for (T i : tempListArr) {
            System.out.print(i + " - ");
        }
        System.out.println();
        */
        this.list[indexNum] = null;
        /*System.out.println("NEW LİST--------------------------------------------------");
        for (T i : list) {
            System.out.print(i + " - ");
        }*/

        for (int i = 0; i < tempListArr.length -1; i++) {
            if (indexNum > i) {
                this.list[i] = tempListArr[i];
            } else if (indexNum == i || i > indexNum){
                this.list[i] = tempListArr[i + 1];
            }
        }
        /*System.out.println();
        System.out.println("NULL SIZ LİST -------------------------------------------------");
        for (T i : list) {
            System.out.print(i + " - ");
        }*/
    }
    public String toString() {
        System.out.print("[");
        for (T i : this.list) {
            if (i != null) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("]");
        return "";
    }

    public int indexOf(T data) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == null) {
                continue;
            }
            if (this.list[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int lastIndex = -1;
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == null) {
                continue;
            }
            if (this.list[i].equals(data)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public boolean isEmpty() {
        boolean isEmpt = false;
        if (size() == 0) {
            isEmpt = true;
        }
        return isEmpt;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[this.list.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.list[i];
        }
        return arr;
    }
}
