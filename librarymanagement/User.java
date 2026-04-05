package librarymanagement;

import java.util.ArrayList;
import java.util.List;

class User {
    private String userId;
    private List<BookCopy> borrowedBooks;

    public User(String userId) {
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(BookCopy copy) {
        borrowedBooks.add(copy);
    }

    public void printBorrowedBooks() {
        for (BookCopy copy : borrowedBooks) {
            System.out.println(copy.getCopyId());
        }
    }

    public List<BookCopy> getBorrowedBooks() {
        return borrowedBooks;
    }
}

