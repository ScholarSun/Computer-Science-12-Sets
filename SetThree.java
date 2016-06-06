
//Set Three - Looping
//Scholar Sun
//February 14 2016
//ICS4UC1
import java.util.Scanner;

public class SetThree {
	public static void main(String[] args) // Main Method
	{
		Scanner sc = new Scanner(System.in);
		char input;
		// Runs Menu Program
		do {
			// Output Menu Screen
			System.out.println("Set Three - Looping Part One");
			System.out.println("---------------------------");
			System.out.println("1. Product");
			System.out.println("2. Factorial");
			System.out.println("3. Invest");
			System.out.println("4. Quit");
			// Input decisions
			input = sc.nextLine().charAt(0);

			// Runs if input equals one
			if (input == '1') {
				clear();
				product();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals two
			else if (input == '2') {
				clear();
				factorial();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals three
			else if (input == '3') {
				clear();
				invest();
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

	// Method for program "product" + instance variables
	public static int total;

	public static void product() {
		
		// Initializes Scanner
		Scanner sc = new Scanner(System.in);
		
		// Prompt for input
		System.out.print("How many numbers to process? ");
		
		// input and variable declaration
		int proc = sc.nextInt();
		int x = 0;
		total = 1;
		
		// Prompt individual products
		System.out.println("Enter " + proc + " positive integers");
		
		// Loops when the number inputed doesnt equal x, which has a starting value of 0
		while (x != proc) {
			// Reads entered integer
			System.out.print("#" + (x + 1) + ": ");
			int entered = sc.nextInt();
			
			//If positive, outputs and multiplies, if the input is not valid, subtracts from the counter by one
			if (entered > 0) {
				total = total * entered;
			} else {
				System.out.println(entered + " not counted");
				x--;
			}
			// Counter increases every time loop runs
			x++;
		}
		
		// Spacing and output
		System.out.println("");
		System.out.println("The product of the positives is: " + total);
		System.out.print("Hit Enter Twice To Return To Menu");
	}

	// Method for program "factorial"
	public static void factorial() {
		// Initializes Scanner
		Scanner sc = new Scanner(System.in);

		// Prompt
		System.out.print("Enter a non-negative integer: ");

		// Reads value of Factorial
		int fac;
		fac = sc.nextInt();

		// Sets initial value of total
		int total = 1;
		int loopfac = fac;

		// Outputs value inputed
		System.out.println(fac + "! =");
		System.out.println("");

		// Prints error message if the total is too big,2147483647 is the max
		if (fac > 12) {
			System.out.println("The total value of the factorial is too large. Try again.");
		}

		// Runs the factorial program if the input is positive
		else if (fac >= 0) {
			for (int x = 0; x <= fac - 1; x++) {
				// Displays output
				System.out.print(loopfac);

				// Final value calculations
				total = total * loopfac;
				loopfac = loopfac - 1;

				// Prints in the multiplication signs
				if (x != (fac - 1)) {
					System.out.print("x");
				}
			}

			// If the inputed value is 0, the answer is automatically 1
			if (fac == 0) {
				System.out.println("= 1");
			}

			// Displays final value
			else {
				System.out.println("= " + total);
			}
		}
		// Prints another error message if the value is not positive
		else {
			System.out.println("Please enter a non-negative value.");
		}
		System.out.print("Hit Enter Twice To Return To Menu");
	}

	// method for program "invest"
	public static void invest() {
		
		// Initializes Scanner
		Scanner sc = new Scanner(System.in);
		
		// Enter Monthly Deposit
		System.out.print("Monthly Deposit($): ");
		double monthly = sc.nextDouble();
		
		// Enter Annual Interest Rate
		System.out.print("Annual Interest Rate(%): ");
		double rate = sc.nextDouble();
		
		// Enter Terms
		System.out.print("Terms (Months): ");
		int term = sc.nextInt();
		System.out.println(term + "\n");
		
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
		
		// Loop amount of terms
		while (x != term) {
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
			x++;
		}
		System.out.print("Hit Enter Twice To Return To Menu");
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
