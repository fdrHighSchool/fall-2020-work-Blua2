package Fall2020;
import java.util.*;

public class Tax{
	public static void main(String[] args){

		Scanner S = new Scanner(System.in);
		System.out.println("Welcome to the Bill-Splitter");
		System.out.print("Enter the total pre-tax: ");
		double total = S.nextDouble();

		System.out.print("How many people? ");
		int numPeople = S.nextInt();

		double tax = total * 0.0725; // Standard tax rate
		double tip =  total * 0.15;	// Standard tip rate
		total = total + tax + tip ; 
		double perPerson = total / numPeople;

		System.out.println("The total with tax and tip is : " + total +"\nEvery persion much pay : " + perPerson);
		S.close();
	}//end main method
}//end classs
