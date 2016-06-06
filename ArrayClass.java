
//Scholar Sun
//ICS4UC1
//May 10 2016
//One D Array Set
//Please configure the clear method if you're using BluJ

import java.io.*;
import java.util.*;

public class ArrayClass {
	// Main to test the outputs
	public static void main(String[] args) throws IOException {

		// Variable declaration
		int i = 0;
		Scanner sc = new Scanner(System.in);
		Array object = new Array();

		// Choice Loop
		do {
			// Menu
			System.out.println("The Name Data Base");
			System.out.println("1.Enter");
			System.out.println("2.Print");
			System.out.println("3.Sort");
			System.out.println("4.Search");
			System.out.println("5.Remove");
			System.out.println("6.Quit");

			i = sc.nextLine().charAt(0);

			// Possible Choices
			if (i == '1') {
				clear();
				enterDriver(object);
				clear();
			} else if (i == '2') {
				clear();
				printDriver(object);
				sc.nextLine();
				clear();
			} else if (i == '3') {
				clear();
				sortDriver(object);
				sc.nextLine();
			} else if (i == '4') {
				clear();
				searchDriver(object);
				sc.nextLine();
			} else if (i == '5') {
				clear();
				removeDriver(object);
			} else if (i == '6') {
				System.out.println("Program Terminated");
			} else {
				System.out.println("Please enter a valid input");
				System.out.print("Hit Enter Twice To Try Again");
				sc.nextLine();
				sc.nextLine();
				clear();
			}
		} while (i != '6');
	}

	// Allows the user to input entries
	public static void enterDriver(Array a) {
		System.out.println("Please input names in form (Last,First)");
		System.out.println("Enter Q to quit");
		a.enter();

	}

	// prints the entries
	public static void printDriver(Array a) {
		System.out.println("The names are:");
		a.print();
	}

	// Sorts the entries
	public static void sortDriver(Array a) {
		a.sort();
		System.out.println("Your database has been sorted");
	}

	// Searches for a certain entry
	public static void searchDriver(Array a) {
		System.out.println("Enter a word or letter to search the database:");
		Scanner sc = new Scanner(System.in);
		Array shortlist = new Array();
		String input = sc.nextLine();
		shortlist = a.search(input);
		shortlist.print();
	}

	// Removes an element from the database
	public static void removeDriver(Array a) {
		System.out.println("Please enter the index you wish to remove");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		a.remove(index);
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

// Read File Class
class ReadFile {
	// File path
	private String path;

	// ReadFile constructor
	public ReadFile(String file_path) {
		path = file_path;
	}

	// Method that counts the number of lines
	public int readLines() throws IOException {

		// Reader Objects
		FileReader file_to_read = new FileReader(path);
		BufferedReader br = new BufferedReader(file_to_read);

		// Variable declaration
		String aLine;
		int numberoflines = 0;

		// Loops through the number of lines
		while ((aLine = br.readLine()) != null) {
			numberoflines++;
		}

		// Close buffered reader
		br.close();

		return numberoflines;
	}

	// Open file method
	public String[] openFile() throws IOException {
		// Declares Objects
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		// Reads the number of lines and creates new array
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];

		// Loops through the lines and assigns them
		for (int i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
		}

		// Closes text reader
		textReader.close();

		return textData;
	}

}

// Array Class
class Array {

	private String[] names;

	// Default Constructor
	Array() {
		names = new String[0];
	}

	// File Input Constructor
	Array(String file_name) throws IOException {
		// Documents file path
		file_name = "C:/Users/ScholarLenovo/Documents/" + file_name;

		// Reads file and lines in the text file
		try {
			// Object declaration
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.openFile();
			this.names = new String[aryLines.length];

			// Assigns the lines to an array
			for (int i = 0; i < aryLines.length; i++) {
				this.names[i] = aryLines[i];
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// Enter Method
	void enter() {
		// Object declaration
		Scanner sc = new Scanner(System.in);
		boolean done = false;

		// Loops input
		while (done == false) {
			String temp = sc.nextLine();

			// Checks for Q, otherwise add
			if (temp.equals("q") || temp.equals("Q")) {
				done = true;
			} else {
				this.add(temp);
			}
		}
	}

	// Adds Entry Method
	void add(String name) {
		// Temporary array and checker setup
		String[] temporary = new String[names.length + 1];
		boolean checker = true;

		// Deletes first spaces
		try {
			while (checker == true) {
				if (name.charAt(0) == ' ') {
					name = name.substring(1, name.length());
				} else {
					checker = false;
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Invalid Input");
		}

		// If the array is initially empty, set it up
		if (names.length == 0) {
			temporary[0] = name;
		}

		// Otherwise add it onto the end
		for (int i = 0; i < names.length; i++) {
			temporary[i] = names[i];
			if (names.length - 1 == i) {
				temporary[i + 1] = name;
			}
		}
		// Sets the temporary
		names = temporary;
	}

	// Print Method
	void print() {
		// Prints all elements of the array
		for (int i = 0; i < names.length; i++) {
			System.out.println("Name:" + names[i]);
		}
	}

	// Search Method
	Array search(String surname) {
		// Sets up new Array object
		Array a = new Array();

		// Loops through all elements
		for (int i = 0; i < names.length; i++) {
			// Variable setup
			String entry = names[i];

			// Checks if the surname exists at 9 and is the same
			if (entry.indexOf(surname) == 0) {
				a.add(entry);
			}
		}
		return a;
	}

	// Overloaded Search Method
	Array search(char first) {
		// New array object
		Array a = new Array();

		// Loops through all the entries
		for (int i = 0; i < names.length; i++) {
			// Checks the first character of each
			String entry = names[i];
			char single = entry.charAt(0);

			// If equal, add to new array
			if (single == first) {
				System.out.println(entry);
				a.add(entry);
			}
		}
		return a;
	}

	// Remove Method
	void remove(int a) {
		// Checks for in bound index
		if (a < 0 || a > names.length) {
			System.out.println("Index out of bounds");
		} else {
			// Creates a shortened array
			String[] temp = new String[names.length - 1];

			// Fills up the elements up until the index
			for (int i = 0; i < a; i++) {
				temp[i] = names[i];
			}

			// Fills up the rest, skipping the indexed
			for (int i = a; i < names.length - 1; i++) {
				temp[i] = names[i + 1];
			}

			// Sets new values
			names = temp;
		}
	}

	// Sorts from high to low
	void sort() {
		// Temporary String
		String temp;

		// Selects the first elements
		for (int x = 0; x < names.length - 1; x++) {
			// Assume the first is the lowest
			int lowPos = x;

			// Checks the rest of the list
			for (int y = x + 1; y < names.length; y++) {
				// Finds a lower value
				if (names[y].charAt(0) < names[lowPos].charAt(0)) {
					// keeps track of the lowest position
					lowPos = y;
				}
			}
			// Swaps low value
			temp = names[x];
			names[x] = names[lowPos];
			names[lowPos] = temp;
		}
	}
}