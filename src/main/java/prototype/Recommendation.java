package prototype;

import java.util.ArrayList;
import java.util.List;

// Represents a book recommendation list for a specific audience
// Allows adding/removing books and creating deep copies for cloning
public class Recommendation implements Prototype {
    private String targetAudience;
    private List<Book> books;

    // Constructor creates a new recommendation for a given audience
    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // Adds a book to this recommendation
    public void addBook(Book book) {
        books.add(book);
    }


    // Removes the first book that matches the given title
    public void removeBookByTitle(String title) {
        Book toRemove = null;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                toRemove = b;
                break; // Remove only the first matching book
            }
        }
        if (toRemove != null) books.remove(toRemove);
    }

    // Changes the target audience of this recommendation
    public void setTargetAudience(String audience) {
        this.targetAudience = audience;
    }

    // Returns the target audience of this recommendation
    public String getTargetAudience() {
        return targetAudience;
    }

    // Returns the list of books in this recommendation
    public List<Book> getBooks() {
        return books;
    }

    // Creates a deep copy of this recommendation
    // Each Book is cloned so that the new recommendation is independent
    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(this.targetAudience);
        for (Book b : this.books) {
            copy.addBook(b.clone());  // Clone each book for deep copy
        }
        return copy;
    }

    // Returns a string representation of this recommendation (audience and books)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for ").append(targetAudience).append(":\n");
        for (Book b : books) {
            sb.append(" - ").append(b.toString()).append("\n");
        }
        return sb.toString();
    }
}
