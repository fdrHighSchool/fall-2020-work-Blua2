import java.util.*;
public class my_first_class_SRC {
    public static void main(String args[]){
        Scanner S = new Scanner(System.in);
        PassWord_gen pass = new PassWord_gen();

        System.out.println("Please enter your full name");
        PassWord_gen.setName(S.nextLine());
        System.out.println("Enter how long you would want your password to be");
        pass.Length = S.nextInt();

        System.out.println("Password: " + pass.PassGen());
        S.close();
    }
}