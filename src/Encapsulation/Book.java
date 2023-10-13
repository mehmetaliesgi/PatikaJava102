package Encapsulation;

public class Book {
    private String bookName;
    private int pageCount;

    public Book(String bookName, int pageCount) {
        this.bookName = bookName;

        if (pageCount < 0) {
            pageCount = 0;
        }
        this.pageCount = pageCount;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getpageCount() {
        return this.pageCount;
    }

    public void setpageCount(int pageCount) {
        if (pageCount < 0) {
            pageCount = 0;
        }
        this.pageCount = pageCount;
    }
}
