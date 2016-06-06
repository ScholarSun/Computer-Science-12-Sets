
//Set Seven - Recursion
//Scholar Sun
//March 12 2016
//ICS4UC1
//Reformatted to be better than ever!

import java.util.Scanner;

public class Recursion {
	public static void main(String[] args) // Main Method
	{
		Scanner sc = new Scanner(System.in);
		char input;
		// Runs Menu Program
		do {
			// Output Menu Screen
			System.out.println("Set Seven - Recursion");
			System.out.println("---------------------------");
			System.out.println("1. GCF Recursion");
			System.out.println("2. GCF Loop");
			System.out.println("3. Fibonacci Recursion");
			System.out.println("4. Fibonacci Loop");
			System.out.println("5. Quit");

			// Input decisions
			input = sc.nextLine().charAt(0);

			// Runs if input equals one
			if (input == '1') {
				clear();
				driverGCFrec();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals two
			else if (input == '2') {
				clear();
				driverGCFloop();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals three
			else if (input == '3') {
				clear();
				driverFibRec();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Runs if input equals four
			else if (input == '4') {
				clear();
				driverFibloop();
				sc.nextLine();
				sc.nextLine();
				clear();
			}
			// Closes program
			else if (input == '5') {
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
		} while (input != '5');
	}
	// Main Method End

	// Method for program "GCF"
	public static int gcfLoop(int a, int b) {
		// Variable Declaration
		int c;
		boolean hai;

		// Placeholder value
		c = 0;

		// Checks for inputed 0
		if (a == 0 || b == 0) {
			return 0;
		}

		// Loops Euclidian Algorithm
		do {
			// Checks which inputed integer is larger and subtracts accordingly
			if (a > b) {
				c = a - b;
				a = c;
				hai = false;
			} else if (b > a) {
				c = b - a;
				b = c;
				hai = false;
			} else { // Once a and b are equal, we have found the GCF
				return b;
			}
		} while (hai == false);
		// Holder
		return c;
	}

	// Method for program GCF recursive
	public static int GCFrecursive(int a, int b) {
		// Variable declaration
		int gcf;
		gcf = 0;

		// 0 checker
		if (a == 0 || b == 0) {
			return 0;
		}

		// If the two values are equal, return one of the values
		if (a == b) { // Base Case
			gcf = a;
		} else if (a < b) { // Orders larger value first
			gcf = GCFrecursive(b, a);
		} else {
			gcf = GCFrecursive(b, a - b); // Euclidian algorithm
		}

		// Returns GCF
		return gcf;

	}

	// method for program "Fibonacci Recursive"
	public static int fibRec(int a) {
		// Base Case, Returns 0 and 1
		if (a == 0) {
			return 0;
		} else if (a == 1) {
			return 1;
		} else {	//Fibonacci algorithm, adds two precious terms
			return fibRec(a - 2) + fibRec(a - 1);
		}
	}

	// method for program "Fibonacci Loop"
	public static int fibLoop(int a) {

		// Declares variables, and assigns values
		int first = 0;
		int second = 1;
		int inter = 0;

		// Loops the amount of terms inputed
		for (int x = 0; x < a; x++) {

			// Saves the second value
			inter = second;

			// Adds together the first and second values
			second = first + second;

			// Moves the 'second' value to be the first
			first = inter;
		}

		// Returns the first
		return first;
	}

	// Driver for GCF Loop Method
	public static void driverGCFloop() {
		//Variables
		int a, b, result;
		
		//Prompt
		Scanner sc = new Scanner(System.in);
		System.out.println("Input two values to compute the GCF:");
		
		//Input
		a = sc.nextInt();
		b = sc.nextInt();
		
		//Sends to method
		result = gcfLoop(a, b);
		
		System.out.println("The GCF of the two inputed values is equal to:" + result);
	}

	// Driver for GCF Recursive Method
	public static void driverGCFrec() {
		//Variables
		int a, b, result;
		
		//Prompt
		Scanner sc = new Scanner(System.in);
		System.out.println("Input two values to compute the GCF: ");
		
		//Inputs
		a = sc.nextInt();
		b = sc.nextInt();
		
		//Sends to method
		result = GCFrecursive(a, b);
		
		System.out.println("The GCF of the two inputed values is equal to: " + result);
	}

	// Driver for Fibonacci Recursive Method
	public static void driverFibRec() {
		//Variables
		int a, result;
		//Prompt
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the term number of the fibonacci sequence");
		
		//Reads and sends into method
		a = sc.nextInt();
		result = fibRec(a);
		
		System.out.println("The value of the given term is: " + result);
	}

	// Driver for Fibonacci Loop Method
	public static void driverFibloop() {
		//Prompt
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the term number of the fibonacci sequence");
		
		//Inputs value and sends to method
		int a = sc.nextInt();
		int result = fibLoop(a);
		
		System.out.println("The value of the given term is: " + result);
	}

	// Method to clear console
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
