package Fall2020;
import java.util.Scanner;
import java.util.Random;

public class steps {
  public static Random num = new Random();
  public static String replay = "Y";
  public int maxguess = 0;
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    while (replay.equalsIgnoreCase("Y")) {
      replay = " ";
      System.out.println(
          "Input difficulty: \n 1. Easy(0-15) \n 2. Intermediate(0-50) \n 3. Hard(0-100) \n 4. Impossible(0-1000)");

      int difficulty = scan.nextInt();

      if (difficulty == 1) {
        games(15, 5);
      }

      else if (difficulty == 2) {
        games(50, 7);
      }

      else if (difficulty == 3) {
        games(100, 8);
      }

      else if (difficulty == 4) {
        games(1000, 12);
      }
    }
  }

  public static int games(int limit, int maxguess) {
    final int ans = num.nextInt(limit);

    System.out.println("\n Input guess");
    int attempts = 0;

    while (maxguess > attempts) {

      int guess = scan.nextInt();
      attempts++;

      // Win
      if (guess == ans) {
        System.out.println(
            "You're Correct!, the number was " + ans + " and you won with " + attempts + " amounts of guesses");

        System.out.println("Input Y to play again and any other key to leave.");
        String rep = scan.nextLine();

        if (rep.equalsIgnoreCase("Y")) {
          replay = "Y";
        } else {
          System.out.println("Thank you for playing.");
          replay = " ";
          break;
        }
      }

      else if (guess > ans) {
        System.out.print("Your guess was too high, try again");
      }

      else if (guess < ans) {
        System.out.print("Your guess was too low, try again");
      }

      System.out.println("\n You have guessed " + attempts + " times and have " + (maxguess - attempts) + " left.");

      // Lose
      if (attempts == maxguess) {
        System.out.println(" Y O U  L O S E");

        String rep = scan.nextLine();
        System.out.println("Input Y to play again and any other key to leave.");

        if (rep.equalsIgnoreCase("Y")) {
          replay = "Y";
        }

        else if (rep != "Y") {
          System.out.println("Thank you for playing.");
          replay = "";
          break;
        }
      }
    }
    return attempts;
  }
}