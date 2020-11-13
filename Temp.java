package Fall2020;
import java.util.Scanner;

public class Temp {
    static Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, input the following number to convert to a temperature type.");
        System.out.println("1. Celsius to Fahrenheit \n2. Fahrenheit to Celsius");
        int choice = S.nextInt();

        if (choice == 1) {
            C2F();
        } else if (choice == 2) {
            F2C();
        }
    }

    public static void C2F() {
        System.out.println("Input a Celsius temperature to be converted to Fahrenheit.");
        double Cel = S.nextDouble();
        System.out.print(Cel + " C : " + ((Cel * 9 / 5.0) + 32) + " F");
    }

    public static void F2C() {
        System.out.println("Input a Fahrenheit temperature to be converted to Celsius.");
        double Fah = S.nextDouble();
        System.out.print(Fah + " F : " + ((Fah - 32) * (5 / 9.0)) + " C");
    }
}