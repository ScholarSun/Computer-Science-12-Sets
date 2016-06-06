
//Set One Menu Program
//Scholar Sun
//February 13, 2016
//ICS4UC1
//IMPORTANT - SEE BOTTOM FOR CLEAR METHOD (BluJ or Non-BluJ)

import java.text.DecimalFormat;
import java.util.Scanner;

public class MenuSetOne {
public static void main(String[]args)	//Main Method
{
 Scanner sc = new Scanner(System.in);
 char input;
 //Runs the Menu Program
 do
 {
 //Output Menu Screen
 System.out.println("Set One - Review");
 System.out.println("---------------------------");
 System.out.println("1. Interest");
 System.out.println("2. Arithmetic");
 System.out.println("3. Receipt");
 System.out.println("4. Quit");
 //Input decisions 
 input = sc.nextLine ().charAt(0);
 
 //Runs if input equals one
 if (input == '1')
 {
	 clear();
	 interest();
	 sc.nextLine();
	 sc.nextLine();
	 clear();
 }
 //Runs if input equals two
 else if (input == '2')
 {
	 clear();
	 arithmetic();
	 sc.nextLine();
	 sc.nextLine();
	 clear();
 }
 //Runs if input equals three
 else if (input == '3')
 {
	 clear();
	 receipt();
	 sc.nextLine();
	 sc.nextLine();
	 clear();
 }
 //Closes program
 else if (input == '4')
 {
	 System.out.println("Program Terminated");
 } 
 //Suggests another input value
 else
 {
	 System.out.println("Please enter a valid input");
	 System.out.print("Hit Enter Twice To Try Again");
	 sc.nextLine();
	 sc.nextLine();
	 clear();
 }
 }
 //Closes program if input is equal to four, continues program if otherwise
 while (input != '4');
}// Main Method End
																					
	// Method for program "interest"
	public static void interest() {
    //Prompt
	System.out.println("Interest Calculator");
	System.out.println("Enter principal amount and interest rate:");
	//Initializes Scanner
	Scanner sc = new Scanner(System.in);
	double prin = sc.nextDouble();
	double interest = sc.nextDouble();
	//Displays amount, rounded 2 decimal places
	System.out.printf("Principal ($): "+ "%.2f\n",prin);
	System.out.println("Interest Rate (%): "+ interest);
	//Calculations of interests
	double y1 = (prin*interest)/100;
	double y2 = ((y1+prin)*interest)/100;
	//Displays result, rounds two places
	System.out.printf("Year 1 Interest =$" +  "%.2f\n",y1);
	System.out.printf("Year 2 Interest =$" +  "%.2f\n",y2);
	System.out.print("Hit Enter Twice To Return To Menu");
	}

	// Method for program "arithmetic"
	public static void arithmetic() {
		//Prompt
		System.out.println("Arithemetic Program \nPlease insert two integer values to compute: ");
		//Initializes Scanner
		Scanner sc = new Scanner (System.in);
		//Reads two "integer" (actually doubles) values
		double oper1 = sc.nextDouble();
		double oper2 = sc.nextDouble();
		//Converts to integer
		int roundedone = (int)oper1;
		int roundedtwo = (int)oper2;
		//Outputs the rounded doubles (integers)
		System.out.println("Operand One = "+ roundedone);
		System.out.println("Operand Two = "+ roundedtwo);
		//Calculations (In double because we want to keep decimals for the division answer)
		double add, subtract, divide, multiply;
		add = oper1 + oper2;
		subtract = oper1 - oper2;
		divide = oper1/oper2;
		multiply = oper1*oper2;
		//Reads only three decimal places
		DecimalFormat df = new DecimalFormat("###.###");
		//Display
		System.out.println(roundedone+ " + "+ roundedtwo + " = " + Math.round(add));
		System.out.println(roundedone+ " - "+ roundedtwo + " = " + Math.round(subtract));
		System.out.println(roundedone+ " x "+ roundedtwo + " = " + Math.round(multiply));
		System.out.println(roundedone+ " / "+ roundedtwo + " = " + df.format(divide));
		System.out.print("Hit Enter Twice To Return To Menu");
	}

	// method for program "receipt"
	public static void receipt() {
		//Prompt
		System.out.println("Enter Item Information (price first, then quantity):");
		//Input
		Scanner sc = new Scanner(System.in);
		double price = sc.nextDouble();
		int quant = sc.nextInt();
	    //Output One
		System.out.printf("Price: $" + "%.2f\n",price);
		System.out.println("Quantity: " + quant);
		System.out.println("-----------------------------------");
		//Calculation of final price
		double finalprice = price*quant;
		//Final Output
		System.out.println("Here is your receipt\n");
		System.out.printf(quant +" x $" + "%.2f" + " = " +"%.2f%n",price,finalprice);
		System.out.println("Thank you. Come again.");
		System.out.print("Hit Enter Twice To Return To Menu");
	}
	
	// method to clear console
	public  static void clear()
	{
		//For Non-BluJ
		//Prints a load of new lines to "clear" console
		for(int i = 0; i < 100; i++)
		{
		    System.out.println("");
		}
		//FOR BLUJ USERS:
		//System.out.print('\u000C'); 
	}

}//end