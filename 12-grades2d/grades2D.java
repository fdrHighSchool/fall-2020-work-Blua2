import java.util.*;

class grades2D {
  public static void main(String[] args) {
    // instantiate 2D array (for example, 30 students with 10 grades each)
    int[][] classGrades = new int[30][10];

    classGrades = fillArray(classGrades);

    // use the deepToString() method to display the contents of a 2D-Array
    displayArray(classGrades);
    System.out.println("The top average is student " + (getValedictorian(classGrades) + 1));
    System.out.println("The second top average is student " + (getSalutatorian(classGrades) + 1));
    //System.out.println(find24s(classGrades));

  }//end main method

  /*
   * N: fillArray
   * P: assign random scores to each cell of the 2D-Array
   * I: the 2D-Array of scores
   * R: the filled-up 2D-Array
   * NOTE: edit the code to have a random value from 55 - 100 in each cell
  */
  public static int[][] fillArray(int[][] arr) {
    // fill each cell with row + col
    // what you will do is fill each row with a random int from 55 - 100
    int min = 55, max = 100;
    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        arr[row][col] = (int)(Math.random() * (max - min + 1) + min);
      }// end col for loop
    }// end row for loop

    return arr;
  }// end fillArray method

  /*
   * N: displayArray
   * P: create a visual representation of the grades for each student in the class
   * I: the 2D-Array of scores
   * R: n/a
  */
  public static void displayArray(int[][] arr) {
    for (int row = 0; row < 30; row++) {
      System.out.println("Student " + (row + 1) + ": " + Arrays.toString(arr[row]) + " Average: " + getAverage(arr[row]));
    } //end for loop

  }// end displayArray method

  /*
   * N: getValedictorian
   * P: determine the 1st rank student in the class
   * I: the 2D-Array of scores
   * R: the student with the highest average
  */
  public static int getValedictorian(int[][] arr) {
    double[] averages = new double[30];
    for (int row = 0; row < 30; row++) {
      averages[row] = getAverage(arr[row]);
    } //end for row loop

    double maxValue = averages[0];
    int index = 0;
    for (int i = 0; i < averages.length; i++) {
      if (averages[i] > maxValue) {
        maxValue = averages[i];
        index = i;
      } //end if
    } //end for i loop

    return index;
  }// end getValedictorian method

  /*
   * N: getSalutatorian
   * P: determine the 2nd rank student in the class
   * I: the 2D-Array of scores
   * R: the student with the second highest average
  */
  public static int getSalutatorian(int[][] arr) {
    double[] averages = new double[30];
    for (int row = 0; row < 30; row++) {
      averages[row] = getAverage(arr[row]);
    } //end for loop

    double maxValue = averages[0];
    int index = 0;
    for (int i = 0; i < averages.length; i++) {
      if (averages[i] > maxValue && i != getValedictorian(arr)) {
        maxValue = averages[i];
        index = i;
      } //end if
    } //end for i loop

    return index;
  }// end getSalutatorian method

  /*
   * N: getAverage
   * P: determine the average of an array of ints
   * I: the array of student test scores
   * R: the average
  */
  public static double getAverage(int[] arr) {
    int sum = 0;
    for (int grades : arr) {
      sum += grades;
    }
    return (double)sum / arr.length;
  }// end getAverage method


  /*
   * N: find24s
   * P: iterate through each cell of the 2D Array an determine how many 24s exist
   * I: the 2D Array to inspect
   * R: the count of how many 24s exist
   * NOTE: 24 is just an arbitrary value, used as an example because it's Alfredo's favorite
  */
  public static int find24s(int[][] arr) {
    int count = 0;

    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        if (arr[row][col] == 24) {
          System.out.println(row + " " + col);
          count++;
        }// end if statement
      }// end col for loop
    }// end row for loop

    return count;
  }// end find24s
}// end class