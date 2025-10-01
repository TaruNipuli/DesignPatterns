package prototype;

import java.util.ArrayList;
import java.util.List;

// Represents book recommendation list for a specific target audience
public class Recommendation implements Prototype {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Remove books by title (works for cloned Recommendations too)
    public void removeBook(String title) {
        List<Book> updatedBooks = new ArrayList<>();
        for (Book b : books) {
            if (!b.getTitle().equals(title)) {
                updatedBooks.add(b);
            }
        }
        books = updatedBooks;
    }

    public void setTargetAudience(String newTargetAudience) {
        this.targetAudience = newTargetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    // Deep copy
    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(this.targetAudience);
        for (Book b : this.books) {
            copy.addBook(b.clone());
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for ").append(targetAudience).append(":\n");
        for (Book b : books) {
            sb.append("  - ").append(b.toString()).append("\n");
        }
        return sb.toString();
    }
}
