package SortingBook;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> nameSet = new TreeSet<>();

        nameSet.add(new Book("Star Maker", 255, "Olaf Stapledon", 1999));
        nameSet.add(new Book("Solaris", 224, "Stanislaw Lem", 2002));
        nameSet.add(new Book("Semiosis", 333, "Sue Burke", 2019));
        nameSet.add(new Book("The Sparrow", 528, "Mary Doria Russell", 1997));
        nameSet.add(new Book("Embassytown", 345, "China Mieville", 2012));

        System.out.println("SORT BY NAME");
        System.out.println("---------------------------------------------------------------------------");
        for (Book book : nameSet) {
            System.out.println("Book Name: " + book.getBookName() +
                    "\nNumber of page: " + book.getPageNumber() +
                    "\nAuthor Name: " + book.getAuthorName() +
                    "\nReleased Date: " + book.getPublishDate());
            System.out.println("********************************");
        }

        System.out.println();
        System.out.println("SORT BY PAGE NUMBER");
        System.out.println("---------------------------------------------------------------------------");
        TreeSet<Book> pageNumberSet = new TreeSet<>(new PageNumberComparator());

        pageNumberSet.add(new Book("Star Maker", 255, "Olaf Stapledon", 1999));
        pageNumberSet.add(new Book("Solaris", 224, "Stanislaw Lem", 2002));
        pageNumberSet.add(new Book("Semiosis", 333, "Sue Burke", 2019));
        pageNumberSet.add(new Book("The Sparrow", 528, "Mary Doria Russell", 1997));
        pageNumberSet.add(new Book("Embassytown", 345, "China Mieville", 2012));

        for (Book book : pageNumberSet) {
            System.out.println("Book Name: " + book.getBookName() +
                    "\nNumber of page: " + book.getPageNumber() +
                    "\nAuthor Name: " + book.getAuthorName() +
                    "\nReleased Date: " + book.getPublishDate());
            System.out.println("********************************");
        }
    }


}
