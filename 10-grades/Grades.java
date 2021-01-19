import java.util.*;
public class Grades {
   static int[] grades = {0,0,0,0,0}; //array grades is static so it can be accessed in method mode and in main
public static void main(String args[]){
   Scanner S = new Scanner(System.in);
   double sum = 0;
   int median;
   
   System.out.println("Please input your grades");
   for(int i = 0; i < 5; i++){ //Building an array the size of 5 with a for loop
     grades[i] = S.nextInt();
     sum += grades[i];
   }

   if (grades.length % 2 == 0){//median
    median = grades[grades.length/2] + grades[grades.length/2 - 1]/2;
   }
   else{//median if array isn't even length
    median = grades[grades.length/2];
   }

   sum = sum / 5.0;
   System.out.println("Average: " + sum +"\nMedian: " + median + "\nMode: " + mode(grades, grades.length));
   S.close();
}

   /*
   N  Mode
   P  Calculate the mode of the grades array
   I  Array and integer
   R  Returns maxv which stores mode based on frequency
   */
   public static int mode(int a[],int n) {
      int maxv = 0, maxc = 0, i, j;
      for (i = 0; i < grades.length; i++) {
         int count = 0;
         for (j = 0; j < grades.length; ++j) {//Nested loop to count the elements of the array and store them in maxv which represents the current mode.
            if (a[j] == a[i])
            count++;
         }
         if (count > maxc) {
            maxc = count;
            maxv = a[i];
         }
      }//end of for loop
      return maxv;
   }//End of method mode
}//end of class