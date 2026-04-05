package librarymanagement;


import java.util.*;

class Library {
    private String libraryId;
    private Map<String, Book> books;
    private Map<String, Rack> racks;
    private Map<String, User> users;
    private int totalRacks;

    public Library(String libraryId, int totalRacks) {
        this.libraryId = libraryId;
        this.totalRacks = totalRacks;
        this.books = new HashMap<>();
        this.racks = new HashMap<>();
        this.users = new HashMap<>();

        for (int i = 1; i <= totalRacks; i++) {
            racks.put("R" + i, new Rack(i));
        }
    }

    public List<Integer> addBook(String bookId, String title, List<String> authors, List<String> publishers, List<String> bookCopyIds) {
        Book book = books.getOrDefault(bookId, new Book(bookId, title, authors, publishers));
        List<Integer> addedRackNos = new ArrayList<>();

        for (String copyId : bookCopyIds) {
            Optional<Rack> availableRack = racks.values().stream().filter(rack -> !rack.isOccupied()).findFirst();
            if (availableRack.isPresent()) {
                Rack rack = availableRack.get();
                BookCopy bookCopy = new BookCopy(copyId, book, rack);
                rack.placeBookCopy(bookCopy);
                book.addBookCopy(bookCopy);
                addedRackNos.add(rack.getRackNumber());
            } else {
                break;
            }
        }

        if (!addedRackNos.isEmpty()) books.put(bookId, book);
        return addedRackNos;
    }

    public int removeBookCopy(String bookCopyId) {
        for (Rack rack : racks.values()) {
            if (rack.isOccupied() && rack.getBookCopy().getCopyId().equals(bookCopyId)) {
                rack.removeBookCopy();
                return rack.getRackNumber();
            }
        }
        return -1;
    }

    public String borrowBook(String bookId, String userId, String dueDate) {
        User user = users.computeIfAbsent(userId, id -> new User(userId));
        if (user.getBorrowedBooks().size() >= 5) return "Overlimit";

        Book book = books.get(bookId);
        if (book == null) return "Invalid Book ID";

        Optional<BookCopy> availableCopy = book.getAvailableCopy();
        if (!availableCopy.isPresent()) return "Not available";

        BookCopy copy = availableCopy.get();
        copy.borrow(userId, dueDate);
        user.borrowBook(copy);
        return "Borrowed Book from rack: " + copy.getRack().getRackNumber();
    }

    public String borrowBookCopy(String bookCopyId, String userId, String dueDate) {
        User user = users.computeIfAbsent(userId, id -> new User(userId));
        if (user.getBorrowedBooks().size() >= 5) return "Overlimit";

        Optional<BookCopy> bookCopyOpt = racks.values().stream()
                .filter(rack -> rack.isOccupied() && rack.getBookCopy().getCopyId().equals(bookCopyId))
                .map(Rack::getBookCopy)
                .findFirst();

        if (!bookCopyOpt.isPresent()) return "Invalid Book Copy ID";

        BookCopy bookCopy = bookCopyOpt.get();
        bookCopy.borrow(userId, dueDate);
        user.borrowBook(bookCopy);
        return "Borrowed Book Copy from rack: " + bookCopy.getRack().getRackNumber();
    }

    public String returnBookCopy(String bookCopyId) {
        for (Rack rack : racks.values()) {
            if (!rack.isOccupied()) {
                Optional<BookCopy> borrowedCopy = racks.values().stream()
                        .filter(r -> r.getBookCopy() != null && r.getBookCopy().getCopyId().equals(bookCopyId))
                        .map(Rack::getBookCopy)
                        .findFirst();

                if (borrowedCopy.isPresent()) {
                    borrowedCopy.get().returnCopy();
                    rack.placeBookCopy(borrowedCopy.get());
                    return "Returned book copy " + bookCopyId + " and added to rack: " + rack.getRackNumber();
                }
            }
        }
        return "Invalid Book Copy ID";
    }

    public void printBorrowed(String userId) {
        User user = users.get(userId);
        if (user != null) user.printBorrowedBooks();
    }

    public void search(String attribute, String value) {
        books.values().forEach(book -> book.search(attribute, value));
    }
}

