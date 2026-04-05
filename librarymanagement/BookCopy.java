package librarymanagement;

public class BookCopy {
    private String copyId;
    private Book book;
    private Rack rack;
    private String borrowedBy;
    private String dueDate;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCopy(String copyId, Book book, Rack rack) {
        this.copyId = copyId;
        this.book = book;
        this.rack = rack;
    }

    public String getCopyId() {
        return copyId;
    }

    public Rack getRack() {
        return rack;
    }

    public boolean isBorrowed() {
        return borrowedBy != null;
    }

    public void borrow(String userId, String dueDate) {
        this.borrowedBy = userId;
        this.dueDate = dueDate;
    }

    public void returnCopy() {
        this.borrowedBy = null;
        this.dueDate = null;
    }

    public void printDetails() {
        System.out.println(copyId + " " + rack.getRackNumber());
    }
}

