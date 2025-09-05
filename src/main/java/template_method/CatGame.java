package template_method;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


// * CatGame is a concrete implementation of Game template.
// * Each player is a cat that hunts mice to earn points.
// * The first cat to reach the winning score (10) wins the game.
// * The game proceeds turn by turn, and the user can control
// * whether to move to the next turn or quit the game.

public class CatGame extends Game {
    private List<CatPlayer> players; // List to hold all players
    private int winningScore = 10;
    private Random rand = new Random(); // Random number generator for hunting outcomes
    private int round = 1;
    private boolean gameOver = false; // // To tell if the game was exited by the user
    private Scanner scanner = new Scanner(System.in);

    // Initializes the game with the specified number of players
    @Override
    public void initializeGame(int numberOfPlayers) {
        players = new ArrayList<>(); // Create a new list for players
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new CatPlayer("Cat" + i)); // add players named Cat1, Cat2...
        }


        System.out.println("Welcome to the game! Each cat hunts mice to earn points.");
        System.out.println("First to reach " + winningScore + " points wins!");
        System.out.println("----------------------------------------");
    }

    // Checks if the game should end
    @Override
    public boolean endOfGame() {
        if (gameOver) return true; // if the user chose exit, end the game
        for (CatPlayer player : players) {
            if (player.getScore() >= winningScore) { // check if any player reached winning score
                return true; // game ends
            }
        }
        return false; // game continues
    }

    // Single turn for a player
    @Override
    public void playSingleTurn(int playerIndex) {
        CatPlayer player = players.get(playerIndex); // Get the player whose turn it is

        System.out.println("Round " + round + " - " + player.getName() + "'s turn to hunt a mouse...");

        int chance = rand.nextInt(100); // generate a random number 0-99
        int pointsEarned = 0; // initialize points earned this turn

        // Determine outcome based on chance
        if (chance < 70) {
            pointsEarned = 2; // Caught a normal mouse
            System.out.println(player.getName() + " caught a mouse! +2 points.");
        } else if (chance < 90) {
            pointsEarned = 0; // Missed the mouse
            System.out.println(player.getName() + " missed the mouse! +0 points.");
        } else {
            pointsEarned = 5; // Caught a big mouse
            System.out.println(player.getName() + " caught a BIG mouse! +5 points!");
        }

        player.addPoints(pointsEarned); // add points to the player's total score

        // Display current scores for all players
        System.out.println("Current scores:");
        for (CatPlayer p : players) {
            System.out.println(p.getName() + ": " + p.getScore());
        }
        System.out.println("----------------------------------------");

        // Ask user to continue or exit
        System.out.print("Press Enter to continue to the next turn or type 'exit' to quit: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) { // if input is exit
            gameOver = true; // end the game
        }

        // Increment round after the last player's turn
        if (playerIndex == players.size() - 1) {
            round++; // advance to next round
        }
    }

    // Display the winner of the game
    @Override
    public void displayWinner() {
        if (gameOver) { // if user exited
            System.out.println("Game was ended by a player. No winner.");
            return;
        }

        // Find player with the highest score
        CatPlayer winner = players.get(0);
        for (CatPlayer player : players) {
            if (player.getScore() > winner.getScore()) {
                winner = player; // Update winner if current player has more points
            }
        }

        System.out.println("The winner is " + winner.getName() + " with " + winner.getScore() + " points, the best mouse hunter!");
    }
}
