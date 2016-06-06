
//Set Four - WhileLoops
//Scholar Sun
//February 21 2016
//ICS4UC1
//See bottom for clear method BluJ vs NonBluJ
import java.util.Random;
import java.util.Scanner;

public class SetFourJava {
	public static void main(String[] args) // Main Method
	{
		Scanner sc = new Scanner(System.in);
		char input;
		// Runs Menu Program
		do {
			// Output Menu Screen
			System.out.println("Set Two - Decisions");
			System.out.println("---------------------------");
			System.out.println("1. Invest 2");
			System.out.println("2. Bank Account");
			System.out.println("3. HiLo");
			System.out.println("4. Quit");
			// Input decisions
			input = sc.nextLine().charAt(0);
			Random ran = new Random();
			int hai = ran.nextInt(6) + 1;

			// Runs if input equals one
			if (input == '1') {
				clear();
				invest2();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals two
			else if (input == '2') {
				clear();
				bankaccount();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals three
			else if (input == '3') {
				clear();
				HiLo();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Closes program
			else if (input == '4') {
				System.out.println("Program Terminated");
			}
			// Suggests another input value
			else {
				System.out.println("Please enter a valid input");
				System.out.print("Hit Enter Twice To Try Again");
				sc.nextLine();
				sc.nextLine();
				clear();
			}
		}
		// Closes program if input is equal to four, continues program otherwise
		while (input != '4');
	}// Main Method End

	// Method for program "invest2"
	public static void invest2() {

		// Initializes Scanner
		Scanner sc = new Scanner(System.in);

		// Enter Monthly Deposit
		System.out.print("Monthly Deposit ($): ");
		double monthly = sc.nextDouble();

		// Enter Annual Interest Rate
		System.out.print("Annual Interest Rate (%): ");
		double rate = sc.nextDouble();

		// Enter Terms
		System.out.print("Target Value ($): ");
		int target = sc.nextInt();

		// Counter Declaration
		int x = 0;

		// Initial Subheadings
		System.out.println("Starting	Interest	Monthly		Ending");
		System.out.println("Balance		Earned		Deposit		Balance");
		System.out.println("---------      ---------       ---------       ---------");

		// Variable declaration and initial values
		double starting, earned, ending;
		starting = 0;
		earned = 0;

		// Loops the calculations
		do {
			
			// Makes sure the earned value doesnt add up
			earned = 0;
			
			// Calculates money earned from interest
			earned = ((rate / 12) / 100) * starting;
			
			// Basic formula for calculating the ending amount
			ending = starting + monthly + earned;
			
			// Output
			System.out.printf("%8.2f", starting);
			System.out.printf("%15.2f", earned);
			System.out.printf("%16.2f", monthly);
			System.out.printf("%16.2f%n", ending);
			
			// Calculates the starting amount for the next term
			starting = earned + ending;
			
			// Counter + 1
			x++;
		}// makes sure the amount you earned stops when greater than target
		while (starting < target);
		
		// Output
		System.out.println("It took " + x + " months to reach your target.");
		System.out.print("Hit Enter Twice To Return To Menu");
	}

	// Method for program "BankAccount"
	public static double deposits, withdrawls, ending;

	public static void bankaccount() {
		// Initializes Scanner
		Scanner sc = new Scanner(System.in);
		
		// variable declaration
		double starting;
		int counter;
		counter = 0;
		
		// Output starting balance
		System.out.print("Starting Balance: ");
		starting = sc.nextDouble();
		System.out.println("");
		
		// loops calculations
		do {
			// counter +1
			counter++;
			
			// Input Deposits, breaks loop if -1
			System.out.print("Month #" + counter + "\tDeposits: ");
			deposits = sc.nextDouble();
			if (deposits == -1) {
				break;
			}
			System.out.print("       \t\t");
			// Input Withdrawals
			System.out.print("Withdrawals: ");
			withdrawls = sc.nextDouble();
			System.out.println("");
			// Calculates ending value
			ending = (starting + deposits) - withdrawls;
		}
		// makes sure you have a positive amount of money in the bank
		while (ending >= 0);
		// If you close the program on the first loop, the starting amount is
		// displayed
		if (deposits == -1 && counter == 1) {
			System.out.printf("You have $%.2f%n%n", starting);
		}
		// Shows final value if -1
		else if (deposits == -1) {
			System.out.printf("You have $%.2f%n%n", ending);
		}
		// If you have a negative value, output 0
		else if (ending <= 0) {
			System.out.println("You have $0 left.");
		}
		System.out.print("Hit Enter Twice To Return To Menu");
	}

	// method for program "HiLo"
	// declare global variables
	public static int randomnu, randomnunext, counter;
	public static boolean correct;

	public static void HiLo() {
		Scanner sc = new Scanner(System.in);
		// Initialized random number
		Random rand = new Random();
		// int hi = rand.nextInt(5)+1;
		counter = 0;
		// loops the input and calculations
		do {
			// initializes the first random number
			if (counter == 0) {
				randomnu = rand.nextInt(100) + 1;
			}
			// Generates the next random number
			randomnunext = rand.nextInt(100) + 1;
			// Prompt
			System.out.print("The number is " + randomnu + ". Next one? (h/l) ");
			// Input
			char input = sc.next().charAt(0);
			// Outlines all the possibilities for h,l
			// If correct, adds one and outs true
			if (input == 'h' && randomnunext >= randomnu) {
				correct = true;
				counter++;
			}
			// If wrong, returns false
			else if (input == 'h' && randomnunext <= randomnu) {
				correct = false;
			}
			// If correct, adds one and outs true
			else if (input == 'l' && randomnunext <= randomnu) {
				correct = true;
				counter++;
			}
			// If wrong, returns false
			else if (input == 'l' && randomnunext >= randomnu) {
				correct = false;
			}
			// Makes the next number the initial number
			randomnu = randomnunext;
		}
		// runs while you input the right answer
		while (correct == true);
		// output
		System.out.print("The number is " + randomnu + ".");
		System.out.println(" You scored " + counter + " points. ");

	}

	// method to clear console
	public static void clear() {
		// For Non-BluJ
		// Prints a load of new lines to "clear" console
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
		// FOR BLUJ USERS:
		// System.out.print('\u000C');
	}

}
