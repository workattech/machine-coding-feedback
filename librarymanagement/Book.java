package librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Book {
        private String bookId;
        private String title;
        private List<String> authors;
        private List<String> publishers;
        private List<BookCopy> copies;

        public Book(String bookId, String title, List<String> authors, List<String> publishers) {
            this.bookId = bookId;
            this.title = title;
            this.authors = authors;
            this.publishers = publishers;
            this.copies = new ArrayList<>();
        }

        public Optional<BookCopy> getAvailableCopy() {
            return copies.stream().filter(copy -> !copy.isBorrowed()).findFirst();
        }

        public void addBookCopy(BookCopy copy) {
            copies.add(copy);
        }

        public void search(String attribute, String value) {
            if ((attribute.equals("book_id") && bookId.equals(value)) ||
                    (attribute.equals("author") && authors.contains(value)) ||
                    (attribute.equals("publisher") && publishers.contains(value))) {
                copies.forEach(BookCopy::printDetails);
            }
        }
    }
