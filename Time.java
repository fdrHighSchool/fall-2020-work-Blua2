package Fall2020;
import java.util.*;

public class Time {
  public static void main(String[] args) {
    // timeset represents the current time in total seconds.
    int timeset = (timecrunchy(7, 36, 19));
    // daysec represents the total seconds in a day
    int daysec = (timecrunchy(24, 0, 0));

    int midsec = (daysec - timeset);
    int remain = (midsec - timeset);
    double timepass = 1.0 * midsec / daysec * 100;

    System.out.println("It has been " + midsec + " seconds since midnight.");
    System.out.println("And there are " + remain + " seconds remaining today.");
    System.out.println(timepass + " percent of the day has passed");

    timeadd(7, 36, 19, 4, 30, 15);
    System.out.print(timebetween(7, 36, 19, 11, 47, 54));
  }

  // timecrunchy is a method that converts time input as 3 parameters (h for hour,
  // m for minute, and s for seconds) into seconds, returning a total number of
  // seconds from the entered information. It will be used to calculate time into
  // total seconds for later use in variables such as midsec and remain,acting
  // primarly as a tool of conversion.

  public static int timecrunchy(int h, int m, int s) {

    int hrsec = (h * 60 * 60);
    int minsec = (m * 60);

    int totalsec = (hrsec += minsec += s);

    return totalsec;
  }

  public static void timeadd(int h, int m, int s, int h1, int m1, int s1) {
    ArrayList<Integer> tset = new ArrayList<Integer>();
    ArrayList<Integer> tadd = new ArrayList<Integer>();
    ArrayList<Integer> nl = new ArrayList<Integer>();

    tset.addAll(Arrays.asList(h, m, s));
    tadd.addAll(Arrays.asList(h1, m1, s1));

    for (int e = 0; e < 3; e++) {
      nl.add(tset.get(e) + tadd.get(e));
    }
    System.out.format("Sum : " + "%02d:%02d:%02d:", nl.get(0), nl.get(1), nl.get(2));
  }

  public static String timebetween(int h, int m, int s, int hend, int mend, int send) {

    int hsum = hend - h;
    int msum = mend - m;
    int ssum = send - s;

    return String.format("\nTime in between : " + "%02d:%02d:%02d:", hsum, msum, ssum);
  }
}