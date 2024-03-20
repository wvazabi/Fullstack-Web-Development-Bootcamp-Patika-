import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book> {
    private String title;
    private int pageCount;
    private String author;
    private String publishDate;

    public Book(String title, int pageCount, String author, String publishDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    @Override
    public int compareTo(Book other) {
        // Kitapları isme göre A'dan Z'ye sırala
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
         return "Title: " + title + ", Page Count: " + pageCount + ", Author: " + author + ", Publish Date: " + publishDate;
    }
}

public class Main {
    public static void main(String[] args) {
        // Kitapları isme göre sıralayan Set
        Set<Book> booksByName = new HashSet<>();

        booksByName.add(new Book("Java Programming", 500, "John Smith", "2022-01-01"));
        booksByName.add(new Book("Algorithms", 400, "Alice Johnson", "2022-02-01"));
        booksByName.add(new Book("Data Structures", 300, "Bob White", "2022-03-01"));
        booksByName.add(new Book("Database Management", 350, "Emma Brown", "2022-04-01"));
        booksByName.add(new Book("Computer Networks", 450, "Michael Davis", "2022-05-01"));

        // İsme göre sıralı kitapları yazdır
        System.out.println("Books sorted by name:");
        for (Book book : booksByName) {
            System.out.println(book);
        }

        // Kitapları sayfa sayısına göre sıralayan Set
        Set<Book> booksByPageCount = new TreeSet<>(new PageCountComparator());
        booksByPageCount.addAll(booksByName);

        // Sayfa sayısına göre sıralı kitapları yazdır
        System.out.println("\nBooks sorted by page count:");
        for (Book book : booksByPageCount) {
            System.out.println(book);
        }
    }
}
