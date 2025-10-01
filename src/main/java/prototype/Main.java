package prototype;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create the system that will hold all recommendations
        RecommendationSystem system = new RecommendationSystem();

        // Create books
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997);
        Book book2 = new Book("The Very Hungry Caterpillar", "Eric Carle", "Children's Picture Book", 1969);
        Book book3 = new Book("The Da Vinci Code", "Dan Brown", "Thriller", 2003);
        Book book4 = new Book("Dune", "Frank Herbert", "Sci-Fi", 1965);

        // Create recommendations for different audiences
        Recommendation rec1 = new Recommendation("Adults");
        rec1.addBook(book3);
        rec1.addBook(book4);
        Recommendation rec2 = new Recommendation("Children");
        rec2.addBook(book2);
        Recommendation rec3 = new Recommendation("Teens");
        rec3.addBook(book1);


        // Add recommendations to the system
        system.addRecommendation(rec1);
        system.addRecommendation(rec2);
        system.addRecommendation(rec3);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main loop for user interaction
        while (running) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. Show all recommendations");
            System.out.println("2. Clone & modify a recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Display all recommendations
                    System.out.println("\n--- All Recommendations ---");
                    system.showRecommendations();
                    break;

                case 2:
                    // Clone an existing recommendation and allow modifications
                    System.out.println("Enter the index of recommendation to clone (starting from 0):");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    // Get a deep copy of the recommendation
                    Recommendation cloned = system.cloneAndModifyRecommendation(index);

                    // Let user set a new target audience
                    System.out.println("Enter new target audience:");
                    String audience = scanner.nextLine();
                    cloned.setTargetAudience(audience);

                    boolean modifying = true;
                    while (modifying) {
                        // Show modification options
                        System.out.println("\nModify cloned recommendation:");
                        System.out.println("1. Add a book");
                        System.out.println("2. Remove a book by title");
                        System.out.println("3. Finish modifying");
                        System.out.print("Choose: ");
                        int modChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (modChoice) {
                            case 1:
                                // Add a new book from user input
                                System.out.println("Enter book info as Title, Author, Genre, Year:");
                                String input = scanner.nextLine();
                                String[] parts = input.split(",");
                                if (parts.length == 4) {
                                    try {
                                        String title = parts[0].trim();
                                        String author = parts[1].trim();
                                        String genre = parts[2].trim();
                                        int year = Integer.parseInt(parts[3].trim());
                                        cloned.addBook(new Book(title, author, genre, year));
                                    } catch (NumberFormatException e) {
                                        System.out.println("Year must be a number.");
                                    }
                                } else {
                                    System.out.println("Invalid input format.");
                                }
                                break;

                            case 2:
                                // Remove a book by title
                                System.out.println("Enter title of book to remove:");
                                String title = scanner.nextLine();
                                cloned.removeBookByTitle(title);
                                break;

                            case 3:
                                modifying = false;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }

                    // Add the modified clone back into the system
                    system.addRecommendation(cloned);
                    System.out.println("Cloned recommendation added.");
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        System.out.println("Exiting Book Recommendation System.");
    }
}
