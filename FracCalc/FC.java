import java.util.*;

public class FC {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

        System.out.println("\nPlease input your expression : ");
        String exp = S.nextLine();
        
        /*
        Match any characters that are provided within the given String, if the string does not contain any of the valid characters continue to else.
        Using .matches can cut down on any unnecessary methods that would check for valid arithmetic.
        */
        if (exp.matches(".*[+-/*].*")){  
            produceAnswer(exp);
            System.out.println("\nRESULT : "+ produceAnswer(exp));
        }
        else {
            System.out.println("\nIllegal arguement : " + "String "+ exp + " does not contain valid arithmetic (+ - / *)"); 
        }
        S.close();
    }//end of main

    public static String produceAnswer(String exp){
        String[] value = exp.split("\\s+");// Split String by the occurrences of blank spaces
        String opr2 = value[2];// Store the third value of the seperated String in opr2

        return opr2;
    }
}//end of class