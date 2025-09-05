package template_method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;

        // Keep asking until user enters at least 2
        while (numberOfPlayers < 2) {
            System.out.print("How many players? (minimum 2): ");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers < 2) {
                System.out.println("You need at least 2 players to play.");
            }
        }

        CatGame game = new CatGame();
        game.play(numberOfPlayers);

        scanner.close();
    }
}
