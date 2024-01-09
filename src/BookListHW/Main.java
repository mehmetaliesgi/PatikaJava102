package BookListHW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Book> bookArrayList = new ArrayList<>();
        HashMap <String, String> bookNameAndAuthor = new HashMap<>();
        ArrayList <Book> moreThan100Page = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            System.out.print("Lütfen " + i + ". kitap ismini giriniz: ");
            String bookName = scanner.next();
            System.out.print("Lütfen " + bookName + " kitabının sayfa sayısını giriniz: ");
            int pageNumber = scanner.nextInt();
            System.out.print("Lütfen yazarın ismini giriniz: ");
            String author = scanner.next();
            System.out.print("Lütfen kitabın yayım tarihini giriniz (dd.mm.yyyy): ");
            String publishDate = scanner.next();
            System.out.println("---------------------------------------------------");
            bookArrayList.add(new Book(bookName, pageNumber, author, publishDate));
        }

        bookArrayList.stream().forEach(book -> {
            bookNameAndAuthor.put(book.getBookName(), book.getAuthorName());
        });

        bookArrayList.stream().filter(book -> book.getPageNumber() > 100).forEach(book -> {
            moreThan100Page.add(book);
        });
    }
}
