import java.util.*;
public class FRQ_2007 {
    static ArrayList<Integer> D = new ArrayList<Integer>();
    public static void main(String[] args){
       System.out.println(isSelfDivisor(129));
       System.out.println(Arrays.toString(firstNumSelfDivisor(10, 3)));
    }

   public static boolean isSelfDivisor(int in){
       int num = in;
       while(in > 0) {
           D.add(in % 10);
           in = in / 10;
       }
        for(int i = 0; i < D.size(); i++){
            if(D.get(i) == 0  || num % D.get(i) != 0){
                return false;
            } 
        }
        return true;
   }

   public static int[] firstNumSelfDivisor(int start, int len){
       int[] divnum =  new int[len]; // divnum is the array that will store all self divisors.
       int current = 0; // current is the stored self divisor number that would be retrieved from the loop.
       int it = start;// it is the iteration of the number for the loop.

        while(current < len){
            if(isSelfDivisor(it)){
                divnum[current] = it;
                current++;
            }
            it++;
        }
       return divnum;
   }// end method firstNumSelfDivisor

}//end class