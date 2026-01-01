import java.util.*;

class Book {
    String id, title, author;
    boolean issued;

    Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

public class LibraryManagementSystem {
    static HashMap<String, Book> library = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Book ID: ");
        String id = sc.next();
        System.out.print("Title: ");
        String title = sc.next();
        System.out.print("Author: ");
        String author = sc.next();

        library.put(id, new Book(id, title, author));
        System.out.println("Book added!");
    }

    static void issueBook() {
        System.out.print("Book ID: ");
        String id = sc.next();
        Book b = library.get(id);
        if (b != null && !b.issued) {
            b.issued = true;
            System.out.println("Book issued!");
        } else {
            System.out.println("Book unavailable!");
        }
    }

    static void returnBook() {
        System.out.print("Book ID: ");
        String id = sc.next();
        Book b = library.get(id);
        if (b != null && b.issued) {
            b.issued = false;
            System.out.println("Book returned!");
        } else {
            System.out.println("Invalid operation!");
        }
    }

    static void viewBooks() {
        for (Book b : library.values()) {
            System.out.println(b.id + " " + b.title + " " + 
                (b.issued ? "Issued" : "Available"));
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add 2.Issue 3.Return 4.View 5.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: addBook(); break;
                case 2: issueBook(); break;
                case 3: returnBook(); break;
                case 4: viewBooks(); break;
                default: System.exit(0);
            }
        }
    }
}