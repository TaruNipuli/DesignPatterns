package prototype;

public class Book implements Prototype {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Book clone() {
        return new Book(this.title, this.author, this.genre, this.publicationYear);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author +
                ", Genre: " + genre + ", Published: " + publicationYear;
    }
}
