package Unit1;
import java.util.Scanner;
import java.util.*;

public class Average {
    public static void main(String[] args) {
        Cal();
    }

    public static void Cal() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Scanner S = new Scanner(System.in);
        int newgrade = 0;
        double avg = 0;

        System.out.println("How many grades did you get?");
        int ngrade = S.nextInt();

        for (int it = 0; it < ngrade; it++) {
            System.out.print("Input your grade");
            nums.add(S.nextInt());
        }

        for (int n : nums)
            newgrade += n;
        avg = newgrade / nums.size();

        System.out.print("\n" + avg);
        S.close();
    }
}