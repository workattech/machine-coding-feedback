package librarymanagement;

class Rack {
    private int rackNumber;
    private BookCopy bookCopy;

    public Rack(int rackNumber) {
        this.rackNumber = rackNumber;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public boolean isOccupied() {
        return bookCopy != null;
    }

    public void placeBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void removeBookCopy() {
        this.bookCopy = null;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }
}
