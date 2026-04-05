package librarymanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equals("exit")) break;

            processCommand(command);
        }
    }

    private static void processCommand(String command) {
        String[] tokens = command.split(" ");
        switch (tokens[0]) {
            case "create_library":
                int numRacks = Integer.parseInt(tokens[1]);
                library = new Library(tokens[1], numRacks);
                System.out.println("Created library with " + numRacks + " racks");
                break;

            case "add_book":
                String bookId = tokens[1];
                String title = tokens[2];
                List<String> authors = Arrays.asList(tokens[3].split(","));
                List<String> publishers = Arrays.asList(tokens[4].split(","));
                List<String> bookCopyIds = Arrays.asList(tokens[5].split(","));
                List<Integer> rackNos = library.addBook(bookId, title, authors, publishers, bookCopyIds);
                if (rackNos.isEmpty()) {
                    System.out.println("Rack not available");
                } else {
                    System.out.println("Added Book to racks: " + rackNos.toString().replaceAll("[\\[\\]]", ""));
                }
                break;

            case "remove_book_copy":
                String bookCopyId = tokens[1];
                int removedRack = library.removeBookCopy(bookCopyId);
                if (removedRack == -1) {
                    System.out.println("Invalid Book Copy ID");
                } else {
                    System.out.println("Removed book copy: " + bookCopyId + " from rack: " + removedRack);
                }
                break;

            case "borrow_book":
                bookId = tokens[1];
                String userId = tokens[2];
                String dueDate = tokens[3];
                String borrowResult = library.borrowBook(bookId, userId, dueDate);
                System.out.println(borrowResult);
                break;

            case "borrow_book_copy":
                bookCopyId = tokens[1];
                userId = tokens[2];
                dueDate = tokens[3];
                borrowResult = library.borrowBookCopy(bookCopyId, userId, dueDate);
                System.out.println(borrowResult);
                break;

            case "return_book_copy":
                bookCopyId = tokens[1];
                String returnResult = library.returnBookCopy(bookCopyId);
                System.out.println(returnResult);
                break;

            case "print_borrowed":
                userId = tokens[1];
                library.printBorrowed(userId);
                break;

            case "search":
                String attribute = tokens[1];
                String attributeValue = tokens[2];
                library.search(attribute, attributeValue);
                break;
        }
    }
}

