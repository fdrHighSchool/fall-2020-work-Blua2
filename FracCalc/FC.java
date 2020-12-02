import java.util.*;

public class FC {
    static ArrayList<String> OPR = new ArrayList<String>();//Global ArrayList was used so I can call it within the produceAnswer method and display it in my main method.
    static ArrayList<Integer> OPRA = new ArrayList<Integer>();
    public static int ssum = 0;
    static int WN = 0; static Boolean Wn = null;//Holding var for conditional statements. (Static for multiple uses)
    static int NM = 0; static Boolean Nm = null;
    static int DM = 0; static Boolean Dm = null;
    static int currentL = 0;//current GCF/LCM holding var
    static int current = 0;
    static String exp = "";
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);    
        Boolean start = true;// Boolean to initialize the loop

        while(start){
            System.out.print("\nInput: ");
            exp = S.nextLine();

            if (exp.indexOf("+") >= 0 || exp.indexOf("-") >= 0 || exp.indexOf("*") >= 0 || exp.indexOf("/") >= 0){//indexOf will see if the inputed String contains any of the strings to compare.
                produceAnswer(exp);
                if(exp.indexOf("_") >= 0 ){// Check if second operand is a mixed fraction
                    if(exp.indexOf("+") >= 0 || exp.indexOf("-") >= 0  ){
                        System.out.println("\nResult: "+ OPRA.get(11) + "_" + OPRA.get(10) + "/" + OPRA.get(9));
                    }
                    else{
                        System.out.println("\nResult: " + OPRA.get(8) + "_" + OPRA.get(6) + "/" + OPRA.get(7));
                    }
                }
                else if(exp.indexOf("/") >= 1 ){// Check if second operand is a fraction
                    System.out.println("\nResult: " +  OPRA.get(6) + "_" + OPRA.get(4) + "/" + OPRA.get(5) );
                }
                else {// if not any 
                    System.out.println("\nResult: "  );
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
            else if(exp.indexOf("_") != 0){
                System.out.println("Expression: " + exp + " does not contain any spaces");
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
            OPRA.clear();
    }
        S.close();
    }//end of main

   /*
    N   produceAnswer
    P   Split the operands accordingly
    I   Inputing expression from main method
    R   Return the parsed String into a ArrayList that contains the 3 characters.
   */
    public static int produceAnswer(String exp){
        OPR.addAll(Arrays.asList(exp.split("\\s+")));//Parse the String into 3 elements by blank spaces
        Collections.swap(OPR, 0, 1); // Swapping operand 1 with operator to keep operator always as the first item, makes it easier to track it after adding more items.

        OPR.addAll(Arrays.asList(OPR.get(1).split("[_/]")));//Parse the operands by additional characters _/ for mixed fractions/fractions.
        OPR.addAll(Arrays.asList(OPR.get(2).split("[_/]")));
        OPR.remove(1);//Removing the parsed operand Strings made in line 66.
        OPR.remove(1);

        for(int i = 1; i < OPR.size(); i++){
            OPRA.add((Integer.parseInt(OPR.get(i))));
        } //Converting all individual numbers in String from OPR to integers and add them all to the empty arraylist OPRA.

        //Both if statements add the parsed String as an element. The reason of using an ArrayList is b/c it would be easier to track the newly parsed characters.
        if(exp.indexOf("_") >= 0){//Check if operand 2 is a mixed fraction
            if(OPR.get(0).equals("+") || OPR.get(0).equals("-")){ 
                currentL = LCM(OPRA.get(2), OPRA.get(5));  
        
                Nm = (OPRA.get(2) < OPRA.get(5)) ? OPRA.add(OPRA.get(1) * currentL / OPRA.get(2)) : OPRA.add(OPRA.get(1) * currentL / OPRA.get(2));//Make num1. equal
                Dm = (OPRA.get(2) < OPRA.get(5)) ? OPRA.add(OPRA.get(2) * currentL / OPRA.get(2)) : OPRA.add(OPRA.get(2) * currentL / OPRA.get(2));//Make denom1. equal
                Nm = (OPRA.get(2) < OPRA.get(5)) ? OPRA.add(OPRA.get(4) * currentL / OPRA.get(5)) : OPRA.add(OPRA.get(4) * currentL / OPRA.get(5));//Make num2. equal
                Dm = (OPRA.get(2) < OPRA.get(5)) ? OPRA.add(OPRA.get(5) * currentL / OPRA.get(5)) : OPRA.add(OPRA.get(5) * currentL / OPRA.get(5));//Make denom2. equal

                OPRA.add(Compute(OPR.get(0), OPRA.get(6), OPRA.get(8)));//add sum numerator.
                OPRA.add(Compute(OPR.get(0), OPRA.get(0), OPRA.get(3)));//add sum whole number.
                current = GCF(OPRA.get(10), OPRA.get(9));//get this current GCF

                DM = (OPR.get(0).equals("+")) ? OPRA.set(9, OPRA.get(9) / GCF(OPRA.get(9), OPRA.get(10))): 0; //Simplify denom if operation is addition, else don't change anything.
                NM = (OPR.get(0).equals("+")) ? OPRA.set(10, OPRA.get(10) / GCF(OPRA.get(9), OPRA.get(10))): 0; //Simplify num if operation is addition, else don't change anything.
                NM = (OPRA.get(9) < OPRA.get(10) && OPR.get(0).equals("+")) ?  OPRA.set(10, OPRA.get(10) / current) : 0; //rewrite numerator.
                WN = (OPRA.get(9) < OPRA.get(10) && OPR.get(0).equals("+")) ?  OPRA.set(11, OPRA.get(11) + 1) : 0; //add whole nums 
                NM = (OPRA.get(9) < OPRA.get(10) && OPR.get(0).equals("+")) ?  OPRA.set(10, OPRA.get(10) % OPRA.get(9)) : 0; //rewrite numerator
            
            return ssum;
            }//end of if
            else if(OPR.get(0).equals("*") || OPR.get(0).equals("/")){
                NM = (OPR.get(0).equals("*")) ? OPRA.set(1, OPRA.get(1) + OPRA.get(0) * OPRA.get(2)): OPRA.set(1, OPRA.get(1) + OPRA.get(0) * OPRA.get(2));//Convert mixed nums to fractions
                NM = (OPR.get(0).equals("*")) ? OPRA.set(4, OPRA.get(4) + OPRA.get(3) * OPRA.get(5)): OPRA.set(4, OPRA.get(4) + OPRA.get(3) * OPRA.get(5));
                Nm = (OPR.get(0).equals("*")) ? OPRA.add(OPRA.get(1) * OPRA.get(4)): OPRA.add(OPRA.get(1) * OPRA.get(5));//Fraction multiplication or division based on operator sign
                Dm = (OPR.get(0).equals("*")) ? OPRA.add(OPRA.get(2) * OPRA.get(5)): OPRA.add(OPRA.get(4) * OPRA.get(2));

                current = (GCF(OPRA.get(6), OPRA.get(7)));
                Wn =(current > 1) ? OPRA.add(0) : OPRA.add(OPRA.get(6) / OPRA.get(7));//add whole num
                NM =(current > 1) ? OPRA.set(7, OPRA.get(7) / current) : OPRA.set(6, OPRA.get(6) % OPRA.get(7));
                DM =(current > 1) ? OPRA.set(6, OPRA.get(6) / current) : 0 ;
                return ssum;
            }//end of else if
            else{return ssum;}
        }//end of if "_"

        else if(exp.indexOf("/") >= 1){//Check if expression contains mixed 
            if(OPRA.get(1) < OPRA.get(3)){
                if(OPR.get(0).equals("+") || OPR.get(0).equals("-")){
                    currentL = LCM(OPRA.get(1), OPRA.get(3));
                    NM = (OPRA.get(1) == currentL) ? OPRA.set(2, OPRA.get(2) * currentL / OPRA.get(3)) : OPRA.set(0, OPRA.get(0) * currentL / OPRA.get(1));//Make num equivalent to LCM
                    DM = (OPRA.get(1) == currentL) ? OPRA.set(3, OPRA.get(3) * currentL / OPRA.get(3)) : OPRA.set(1, OPRA.get(1) * currentL / OPRA.get(1));//Make denom equivalent to LCM
                    
                    OPRA.add(Compute(OPR.get(0),OPRA.get(0),OPRA.get(2)));
                    Wn = (OPRA.get(4) > OPRA.get(3)) ? OPRA.add(OPRA.get(4) / OPRA.get(3)): OPRA.add(0);
                    NM = (OPRA.get(4) > OPRA.get(3)) ? OPRA.set(4, OPRA.get(4) % OPRA.get(3)) : 0;

                    return ssum;
                }
                else if(OPR.get(0).equals("*") || OPR.get(0).equals("/")){//(Progress needed)
                    Nm = (OPR.get(0).equals("*")) ? OPRA.add(OPRA.get(0) * OPRA.get(2)) : OPRA.add(OPRA.get(0) * OPRA.get(3));//New numerators/denominators using LCM.
                    Dm = (OPR.get(0).equals("*")) ? OPRA.add(OPRA.get(1) * OPRA.get(3)) : OPRA.add(OPRA.get(1) * OPRA.get(2));
                    current = GCF(OPRA.get(4), OPRA.get(5));
                    System.out.println(OPRA);
    
                    DM = (current > 1) ? OPRA.set(5, OPRA.get(5) / current) : 0;//Make num equivalent to LCM
                    NM = (current > 1) ? OPRA.set(4, OPRA.get(4) / current) : 0;//Make num equivalent to LCM
                    System.out.println(OPRA);
                    Wn = (OPRA.get(4) > OPRA.get(5)) ? OPRA.add(OPRA.get(4) / OPRA.get(5)): OPRA.add(0);// Final conditionals to reduce ans.
                    NM = (OPRA.get(4) > OPRA.get(5)) ? OPRA.set(4, OPRA.get(4) % OPRA.get(5)) : 0;

                    return ssum;
                }
                else{return ssum;}
            }// end of if
            else{ return ssum;}
        }//end of else if
        else{return ssum;}
    }//end of method produceAnswer

    public static int GCF(int DEN1, int DEN2){return DEN2 == 0 ? DEN1 : GCF(DEN2, DEN1%DEN2);}
    public static int LCM(int DEN1, int DEN2){return DEN2 == 0 ? DEN1 : DEN1 * (DEN2 / GCF(DEN1, DEN2));}
    public static int ADD(int OP1, int OP2) {return OP1 + OP2;}
    public static int SUB(int OP1, int OP2) {return OP1 - OP2;}
    public static int DIV(int OP1, int OP2) {return OP1 / OP2;}
    public static int MUL(int OP1, int OP2) {return OP1 * OP2;}  

   /*
    N   Compute
    P   Computes two operands accordingly
    I   Entering operator, first operand, and second operand as parameters
    R   Return the correct format that corresponds to operator
   */
    public static int Compute(String operator, int OP1, int OP2){
        int sum = 0;
        switch(operator){
            case "+":
             sum = ADD(OP1, OP2);
             return sum;
            case "-":
              sum = SUB(OP1, OP2);
             return sum;
            case "/":
             sum = DIV(OP1, OP2);
             return sum;
            case "*":
             sum = MUL(OP1, OP2);
             return sum;
        }
        return sum;
    }//end of method compute
}//end of class