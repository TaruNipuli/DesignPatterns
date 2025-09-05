package state;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the character
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();
        GameCharacter character = new GameCharacter(name);

        boolean running = true; // Remains true while game is running

        // Game loop
        while (running) {
            // Display character status
            character.printStatus();

            // Display available actions
            System.out.println("Choose an action: ");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    character.train();
                    break;
                case "2":
                    character.meditate();
                    break;
                case "3":
                    character.fight();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting the game...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }

            // End game if the character reaches Master level
            if (character.getCurrentState().getLevelName().equals("Master")) {
                System.out.println("Congratulations! You've reached the Master level!");

                running = false; // Game ends
            }

            System.out.println();

        }
    }
}
