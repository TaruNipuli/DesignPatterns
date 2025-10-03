package facade;

public class Main {
    public static void main(String[] args) {
        // Create the facade instance
        ApiFacade facade = new ApiFacade();

        // Retrieve and print a Chuck Norris joke
        try {
            String joke = facade.getRandomJoke();
            System.out.println("Chuck Norris joke: " + joke);
        } catch (Exception e) {
            System.out.println("Failed to get Chuck Norris joke:");
            e.printStackTrace();
        }

        // Retrieve and print a random cat fact
        try {
            String catFact = facade.getRandomCatFact();
            System.out.println("Random cat fact: " + catFact);
        } catch (Exception e) {
            System.out.println("Failed to get cat fact:");
            e.printStackTrace();
        }
    }
}
