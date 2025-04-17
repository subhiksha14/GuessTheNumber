import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;

        int highScore = 0;
        String highScorePlayer = "None";

        System.out.println("=== Welcome to the Guess the Number Game! ===");

        do {
            System.out.println("\nChoose Difficulty:");
            System.out.println("1. Easy (1-10, 5 attempts)");
            System.out.println("2. Medium (1-50, 7 attempts)");
            System.out.println("3. Hard (1-100, 10 attempts)");
            System.out.print("Enter choice (1-3): ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int maxNumber = 10, attempts = 5;
            switch (choice) {
                case 2:
                    maxNumber = 50;
                    attempts = 7;
                    break;
                case 3:
                    maxNumber = 100;
                    attempts = 10;
                    break;
                case 1:
                default:
                    maxNumber = 10;
                    attempts = 5;
                    break;
            }

            Random rand = new Random();
            int target = rand.nextInt(maxNumber) + 1;
            int tries = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and " + maxNumber);
            System.out.println("You have " + attempts + " attempts.");

            while (tries < attempts) {
                System.out.print("Your guess: ");
                int guess = sc.nextInt();
                sc.nextLine(); // consume newline
                tries++;

                if (guess == target) {
                    System.out.println("Correct! You guessed it in " + tries + " tries.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (tries == 3 && !guessedCorrectly) {
                    if (target % 2 == 0) {
                        System.out.println("Hint: The number is even");
                    } else {
                        System.out.println("Hint: The number is odd");
                    }
                }
            }

            int score = 0;
            if (guessedCorrectly) {
                score = attempts - tries + 1;
                System.out.println("[*] Your score: " + score);
            } else {
                System.out.println("[X] You've used all your attempts. The number was: " + target);
                System.out.println("[*] Your score: " + score);
            }

            if (score > highScore) {
                System.out.print("Enter your name for the leaderboard: ");
                String name = sc.nextLine();
                highScore = score;
                highScorePlayer = name;
                System.out.println("\n[!] High Score: " + highScorePlayer + " with " + highScore + " points!");
            } else {
                System.out.println("\n[!] Current High Score: " + highScorePlayer + " with " + highScore + " points.");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.nextLine().trim().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing! Goodbye.");
        sc.close();
    }
}
