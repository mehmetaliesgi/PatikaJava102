package SortingBook;

import java.util.Comparator;

public class Book implements  Comparable<Book> {
    private String bookName;
    private int pageNumber;
    private String authorName;
    private int publishDate;


    public Book() {

    }
    public Book(String bookName, int pageNumber, String authorName, int publishDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublishDate() {
        return publishDate;
    }

 /*   @Override
    public int compare(Book o1, Book o2) {
        return o1.getBookName().compareTo(o2.getBookName());
    }*/

    @Override
    public int compareTo(Book o) {
        return this.bookName.compareTo(o.bookName);
    }
}
