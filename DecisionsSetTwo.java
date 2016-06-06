//Set Two - Decisions
//Scholar Sun
//February 13 2016
//ICS4UC1
//IMPORTANT - Go to bottom to configure clear method (BluJ or Non-BluJ)
import java.text.DecimalFormat;
import java.util.Scanner;

public class DecisionsSetTwo {public static void main(String[]args)	//Main Method
{
	 Scanner sc = new Scanner(System.in);
	 char input;
	 //Runs Menu Program 
	 do
	 {
	 //Output Menu Screen
	 System.out.println("Set Two - Decisions");
	 System.out.println("---------------------------");
	 System.out.println("1. Pizza");
	 System.out.println("2. Equation");
	 System.out.println("3. PayCheque");
	 System.out.println("4. Quit");
	 //Input decisions 
	 input = sc.nextLine ().charAt(0);
	 
	 //Runs if input equals one
	 if (input == '1')
	 {
		 clear();
		 pizza();
		 sc.nextLine();
		 sc.nextLine();
		 clear();
	 }
	 //Runs if input equals two
	 else if (input == '2')
	 {
		 clear();
		 equation();
		 sc.nextLine();
		 sc.nextLine();
		 clear();
	 }
	 //Runs if input equals three
	 else if (input == '3')
	 {
		 clear();
		 paycheque();
		 sc.nextLine();
		 sc.nextLine();
		 clear();
	 }
	 //Closes program if equals 4
	 else if (input == '4')
	 {
		 System.out.println("Program Terminated");
	 } 
	 //Suggests another input value if no valid input
	 else
	 {
		 System.out.println("Please enter a valid input");
		 System.out.print("Hit Enter Twice To Try Again");
		 sc.nextLine();
		 sc.nextLine();
		 clear();
	 }
	 }
	 //Closes program if input is equal to four, continues to run if not
	 while (input != '4');
	}// Main Method End
																						
		// Method for program "pizza"
		public static void pizza() {
		System.out.print("Number of pizzas: ");
		//Initialize scanner
		Scanner sc = new Scanner (System.in);
		//Scanner reads input
		int amount = sc.nextInt();
		//System.out.println(amount);
		
		System.out.print("Size: ");
		sc.nextLine();
		char size = sc.nextLine().charAt(0);
		System.out.println("");
		//Variable declaration
	    double sizeprice;
	    //Checks the character of variable "size"
	    switch (size)
	    {
	    //if equals s, price is 6.99
	    case 'S': case 's':
	    	sizeprice = 6.99;
	    	break;
	    //if equals m, price is 8.99
	    case 'M': case 'm':
	    	sizeprice = 8.99;
	    	break;
	    //if equals l, price is 10.99
	    case 'L': case 'l':
	    	sizeprice = 10.99;
	    	break;
	    //if the input is anything else, assume its a large pizza
	    default: sizeprice = 10.99;
	    size = 'L';
	    break;
	    }
	    //Calculates final price
	    double finalprice = sizeprice*amount;	    
	    //Output with rounded values (2 decimal places)
		System.out.printf(amount+ " @ " +sizeprice +" = "+ "$%.2f%n",finalprice);
		
		System.out.println("Hit Enter Twice To Return To Menu");
		}

		// Method for program "equation"
		public static void equation() 
		{
		//Prompt for A and B values
		System.out.println("Enter Values for Ax + B = 0");
		//Initializes scanner
		Scanner sc = new Scanner (System.in);
		//Input A
		System.out.print("A: ");
		double A = sc.nextInt();
		int intA = (int) A;
		//Input B
		System.out.print("B: ");
		double B = sc.nextInt();
		int intB = (int) B;
		System.out.println("");
		//Calculates value of "x"
		double xval = (-B/A);
		//Rounds final answer to three decimal places
		DecimalFormat df = new DecimalFormat("###.###");
		//Output Screen
		System.out.println(intA + "x " +"+ "+ intB + "=" + " 0 ");
		System.out.println(intA+"x " + "= " + (-intB));
		System.out.println("x= "+ (-intB+ "/" +intA));
		//Checks if A is equal to zero, if so declares the answer is undefined
		if (A==0)
		{
			System.out.println("Undefined");
		}
		else //if not undefined, return the value of x 
		{
			System.out.println("x="+ (df.format(xval)));		
		}
		
		System.out.println("Hit Enter Twice To Return To Menu");
		}
		
		// method for program "paycheque"
		//instance variables
		public static double hours;
		public static void paycheque() {
		//Prompt
		System.out.println("Please enter the hourly wage and the hours worked this week.");
		//Initializes Scanner
		Scanner sc = new Scanner (System.in);
		//Inputs values & prompts
		System.out.print("Hourly Wage: ");
		double wage = sc.nextDouble();
		System.out.print("Hours Worked: ");
		hours = sc.nextDouble();
		System.out.println("");
		//Checks how many hours overtime, if greater than 40, return extra, if not return 0
		double extrahours = hours > 40 ? hours-40 : 0;
		//Calculates how much is made
		double regpay = hours*wage;
		double overpay = extrahours*(wage * 1.5);
		double total = regpay + overpay;
		//Outputs final values and rounds
		System.out.printf("Regular Pay: $%.2f%n",regpay);
		System.out.printf("Overtime Pay: $%.2f%n", overpay);
		System.out.printf("Total pay: $%.2f%n", total);
		
		System.out.println("Hit Enter Twice To Return To Menu");
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

}
