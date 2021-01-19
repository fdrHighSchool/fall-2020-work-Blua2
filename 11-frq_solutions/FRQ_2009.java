import java.util.*;
public class FRQ_2009{
  static ArrayList<Integer> D = new ArrayList<Integer>();
  static int cube[]={1,2,6,4,6,6};
  static Random ran = new Random();
  public static void main(String[] args){
    System.out.println(Arrays.toString(getCubeTosses(cube, 6)));
    System.out.println(getLongestRun(cube));
  }

  public static int[] getCubeTosses(int[] numcube, int toss){
    int[] numtoss = new int[toss];

    for (int i = 0; i < toss; i++){
      numtoss[i] = cube[ran.nextInt(6)];
    }
    return numtoss;
  }

  public static int getLongestRun(int[] cube){
    int current = 0;
    int max = 0;
    int start = -1;
  
    for(int i = 0; i < cube.length-1; i++){
      if(cube[i] == cube[i+1]){
        current++;
        if(current > max){
          max = current;
          start = i - current + 1;
        }
      }
      else{
        current = 0;
      }
    }
    return start; 
   }  
}
