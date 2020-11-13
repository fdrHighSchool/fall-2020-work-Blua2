package Fall2020;
import java.util.Random;
import java.util.*;

public class Email {
  // Making these variable accessable to methods.
  static final String lc = "abcdefghijkmnlopqrstuvwxyz";
  static final String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static final String td = "0123456789";
  static final String punc = "!@#$%^&*()_+-=[]|?.,<>;:";
  static Scanner S = new Scanner(System.in);
  static Random ran = new Random();
  static ArrayList<String> vars = new ArrayList<String>();

  public static void main(String[] args) {
    ID("Bryant", "Luna", 219772290);
    pw();
  }

  public static void ID(String fname, String lname, int ID) {
    String F = String.format("%.1s", fname);
    int ld = ID % 10000;
    System.out.printf("Email : " + F + lname + ld + "@fdrhs.org \n");
  }

  public static void pw() {
    // Inputing characters in 4 different variables.
    // Adding these 4 variables as elements into the empty declared "vars"
    // Arraylist.
    vars.add(lc);
    vars.add(uc);
    vars.add(td);
    vars.add(punc);

    // Declaring password as an empty variable to then concate onto in the 12
    // character for loop.
    String password = " ";
    for (int word = 0; word < 12; word++) {
      // Collections shuffling during each iteration allows for a completely random
      // Arraylist in every iteration. Calling on element 0.

      Collections.shuffle(vars);
      String iterate = vars.get(0);

      password = (password + (iterate.charAt(ran.nextInt(iterate.length()))));
    }
    System.out.print("Password :" + password);
  }
}