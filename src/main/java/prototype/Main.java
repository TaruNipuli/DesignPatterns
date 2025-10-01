package prototype;

// Main program to demonstrate recommendation system
public class Main {
    public static void main(String[] args) {

        // Create books
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 1997);
        Book book2 = new Book("The Very Hungry Caterpillar", "Eric Carle", "Children's Picture Book", 1969);
        Book book3 = new Book("The Da Vinci Code", "Dan Brown", "Thriller", 2003);
        Book book4 = new Book("Dune", "Frank Herbert", "Sci-Fi", 1965);
        Book book5 = new Book("Percy Jackson and the Lightning Thief", "Rick Riordan", "Fantasy", 2005);
        Book book6 = new Book("Green Eggs and Ham", "Dr. Seuss", "Children's Picture Book", 1960);


        // Create recommendations
        Recommendation recommendation1 = new Recommendation("Adults");
        recommendation1.addBook(book3);

        Recommendation recommendation2 = new Recommendation("Children");
        recommendation2.addBook(book2);

        Recommendation recommendation3 = new Recommendation("Teens");
        recommendation3.addBook(book1);

        // Create recommendation system and add recommendations
        RecommendationSystem system = new RecommendationSystem();
        system.addRecommendation(recommendation1);
        system.addRecommendation(recommendation2);
        system.addRecommendation(recommendation3);

        // Show original recommendations
        System.out.println("---Original Recommendations---");
        system.showRecommendations();

        // Modify Adults recommendation
        Recommendation recommendationToModify = system.getRecommendation(0); // Adults
        recommendationToModify.setTargetAudience("Adults who like Sci-Fi"); // Change audience
        recommendationToModify.addBook(book4); // Add new book (Dune)
        recommendationToModify.removeBook("The Da Vinci Code"); // Remove old book from Adult recommendation

        // Modify Children recommendation
        Recommendation childrenRec = system.getRecommendation(1);
        childrenRec.setTargetAudience("Children who love picture books");
        childrenRec.addBook(book6);
        childrenRec.removeBook("The Very Hungry Caterpillar");

        // Modify Teens recommendation
        Recommendation teensRec = system.getRecommendation(2);
        teensRec.setTargetAudience("Teens who enjoy fantasy");
        teensRec.addBook(book5);
        teensRec.removeBook("Harry Potter and the Philosopher's Stone");

        // Show all recommendations after modification
        System.out.println("---All Recommendations After Modification---");
        system.showRecommendations();
    }
}
