import java.util.*;

public class FC {
    static ArrayList<String> OPR = new ArrayList<String>();//Global ArrayList was used so I can call it within the produceAnswer method and display it in my main method.
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);    
        Boolean start = true;

        while(start){
            System.out.print("\nInput: ");
            String exp = S.nextLine();
           // exp = exp.replaceAll("\\s","");//This calculator will not be using blank spaces to indicate to split since it can cause problems when reading characters.

            if (exp.indexOf("+") >= 0 || exp.indexOf("-") >= 0 || exp.indexOf("*") >= 0 || exp.indexOf("/") >= 0){//indexOf will see if the inputed String contains any of the strings to compare.
                produceAnswer(exp);
                if(OPR.get(2).indexOf("_") >= 0){
                    System.out.println("\nWHOLE: " + OPR.get(3) +"\nNUMERATOR: " + OPR.get(4) + "\nDENOMINATOR: " + OPR.get(5));//Print results
                }
                else if(OPR.get(2).indexOf("/") >= 1){
                    System.out.println("\nWHOLE NUMBER: 0" + "\nNUMERATOR: " + OPR.get(3) + "\nDENOMINATOR: " + OPR.get(4));//Print results
                }
                else {
                    System.out.println("\nWHOLE NUMBER: " + OPR.get(2) +"\nNUMERATOR: 0"  + "\nDENOMINATOR: 1");//Print results
                }
            }
            else if(exp.equalsIgnoreCase("quit")){
                System.out.println("Goodbye");
                start = false;
            }
            else if(exp.equalsIgnoreCase("off")){
                System.out.println("OFF");
                exp = S.nextLine();
            }
            else if(exp.equalsIgnoreCase("on")){
                System.out.println("ON");
                exp = S.nextLine();
            }
            else {
                System.out.println("\nIllegal arguement : " + "String "+ exp + " does not contain valid arithmetic (+ - / *)"); 
            }
            OPR.clear();
    }
        S.close();
    }//end of main

    public static ArrayList<String> produceAnswer(String exp){
        OPR.addAll(Arrays.asList(exp.split("\\s+")));
        Collections.swap(OPR, 0, 1); // Swapping operand 1 with operator to keep operator the same in all scenarios.

        if(OPR.get(2).indexOf("_") >= 0){//Check if operators are fractions
            OPR.addAll(Arrays.asList(OPR.get(2).split("[_/]")));
            return OPR;
        }
        else if(OPR.get(2).indexOf("/") >= 0 ){
            OPR.addAll(Arrays.asList(OPR.get(2).split("[/]")));
            return OPR;
        }
        else{
            return OPR;
        }
    }    
}//end of class