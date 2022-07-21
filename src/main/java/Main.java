import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("================ Welcome to my library! ================");

        try (Scanner scanner = new Scanner(System.in);) {

            while (true) {
                System.out.print("Enter the name of the book you want to search for: ");
                String bookName = scanner.nextLine();
                System.out.println();
                Optional<String> optAuthor = Book.getAuthor(bookName);
        
                // write your code here
                optAuthor.ifPresentOrElse(
                        (value) -> System.out.println("bookName = '" + bookName + "'" + "\n\n'" + bookName + " written by " + value + "'"),
                        () -> System.out.println("Unknown")
                );
                System.out.println("================================================");
            }
        } catch (InputMismatchException ioInputMismatchException) {
            System.out.println("ERROR: Invalid Input");
        }

    }
}

// DO NOT MODIFY the code below //
class Book {
    private static final Map<String, String> books = new HashMap<>();

    static {
        books.put("Effective Java", "Joshua Bloch");
        books.put("Designing Data-Intensive Applications", "Martin Kleppmann");
        books.put("Modern Java in Action", "Raoul-Gabriel Urma");
    }

    static Optional<String> getAuthor(String name) {
        return Optional.ofNullable(books.get(name));
    }
}
