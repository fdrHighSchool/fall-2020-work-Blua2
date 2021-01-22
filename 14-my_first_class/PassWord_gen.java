import java.util.*;
public class PassWord_gen{
    private String lc = "abcdefghijkmnlopqrstuvwxyz";
    private String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String nm = "0123456789";
    private String punc = "!#$%^&*_?.,";
    Random R = new Random();
    static ArrayList<String> Chars = new ArrayList<String>();
    static ArrayList<String> Name = new ArrayList<String>();
    int Length;
    static private String password;

    public static void setName(String name){//Setter for Name and store it in an ArrayList which would store the first and last name according to spacing 
        Name.addAll(Arrays.asList(name.split("\\s+")));
    }

    /*
    N PassGen
    P Generate a random password for the user
    I No parameters but it uses multiple private variables
    R Returns a password as String
    */
    String PassGen(){
        //The strings of different characters are added to one ArrayList so they can be accessed as a element when iterated
        Chars.add(lc);
        Chars.add(uc);
        Chars.add(nm);
        Chars.add(punc);
        password = Name.get(0).charAt(0) + Name.get(1);//Make the start of password use the first letter of the first name and complete last name.

        for(int Char = 0; Char < this.Length; Char++){
            Collections.shuffle(Chars);//Shuffle will make the element selection constantly random every iteration
            String iterate = Chars.get(0);//iterate will represent the elements of character Array

            password = (password + (iterate.charAt(R.nextInt(iterate.length()))));//Retrieve a single random character from the list of characters.
        }//end for loop
        return password;
    }//end PassGen method
}    