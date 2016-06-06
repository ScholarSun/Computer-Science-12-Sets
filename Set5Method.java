//Set 5, Methods
//Scholar Sun
//ICS 4UC1
//February 27, 2016
//Note: Configure clear method for BluJ or Non-BluJ at the bottom of program

import java.util.Scanner;

public class Set5Method {
//Main Method
public static void main(String[]args)
{
	//Initializes Scanner
	Scanner sc = new Scanner (System.in);
	//Variable declaration
	boolean againboo;
	//Runs the program
	do 
	{
		//Displays title
		title();
		//Formatting and prompt
		System.out.println("");
		System.out.print("How many pairs to process? ");
		//runs method readChar, assigns return value
		char input = readChar('1','9');
		System.out.println("");
		//converts it to integer value
		int numpairs = Character.getNumericValue(input);	
			System.out.println("Numbers\t\t"+"LCM");
			//Loops amount of times based on input
			for (int x = 0; x<numpairs;x++)
			{
				//Generates two random numbers
				int one = getrandom(1,100);
				int two = getrandom(1,100);
				//output random numbers
				System.out.print(one+"\t");
				System.out.print(two+"\t");
				//Calculates lowest common multiple
				int LCD = lcm(one, two);
				//Displays lcm
				System.out.print(LCD);
				System.out.println("");
			}
		//Asks user if he/she wants to go again
		System.out.println("");
		System.out.print("Want to go again? ");
		//Checks if input is correct
		CharSequence again = readChar("YyNn");
			//If y, run again , if n, stop
			if (again.equals("y")||again.equals("Y"))
			{
				againboo = true;
				//Method that clears console
				clear();
			}
			else 
			{
				againboo = false; 
			}
	}	
	//Runs again if user enters y or Y
	while(againboo==true);
}
//Main method end

//Method that prints a box around the input
public static void title()
{
	//Makes the title the LCM machine
	String input = "The LCM Machine";
	//Measures length of the title
	int length = input.length();
		//prints out a certain number of "-" for the title
		for (int x=0;x<length+4;x++)
		{
			System.out.print("-");
		}
	//Lines for formatting and the side of the box
	System.out.println("");
	System.out.print("| "+input+" |");
	System.out.println("");
		//prints out more "-" for the final side
		for (int x=0;x<length+4;x++)
		{
			System.out.print("-");
		}
	System.out.println("");
}
//method that produces a random number between a and b
public static int getrandom(int a,int b)
{
	//filler
	int random=0;
	//generates the random number based on which integer is greater
	if (a>b)
	{
		//assigns a value of the range
		int range = (a-b)+1;
		//random number generator
		random = (int)(Math.random()*range)+b;
		return random;
	}
	//generates the random number based on which integer is greater
	else if(b>a)
	{
		//assigns a value of the range
		int range = (b-a)+1;
		//generates random number
		random = (int)(Math.random()*range)+a;
		return random;
	}
	//filler
	return random;
}
//Method that forces user to enter a value between the two characters in the alphabet
public static char readChar(char a, char b)
{
	//initializes the scanner
	Scanner sc = new Scanner(System.in);
	//boolean that dictates the amount of loops
	boolean correct = false;
	//filler
	char input=' ';
	//Loops while an input is invalid
	while(correct == false)
	{	
		//reads character
		input = sc.nextLine().charAt(0);
		//if entered value is between  a and b return it
		if(a>=input && input>=b)
		{
			return input;
		}
		//if entered value is between  b and a return it
		else if(b>=input && input>=a)
		{
			return input;
		}
		//if entered value is not between a and b enter an error message and continue loop
		else
		{
			System.out.println("Error, between "+a+" and "+b+" only.");
			correct =false;
		}	
	}	
//filler return
return input;
}
//Method that overloads readChar method and accepts a string, check if input contains
public static CharSequence readChar(String a)
{
	//Initializes scanner
	Scanner sc = new Scanner (System.in);
	//Declares variable correct
	boolean correct;	
	//filler value
	CharSequence input = "filler";
	correct = false;
		//runs loop while user inputs an invalid character
		while (correct == false)	
		{
			//user input
			input = sc.nextLine(); 
			//is the input contained in the accepted string?
			if(a.contains(input))
			{
				//if so return that value
				correct = true;
				return input;
			}
			//if not runs loop again
			else
			{
				System.out.print("Error yYnN only: ");
				correct = false;
			}
		}	
	//filler
	return input;
}
//method that calculates the lowest common multiple of two accepted integers
public static int lcm(int a, int b)
{
	//variable declaration
	int lowest;
	int filler = 0;
	//If one of the values equal to 0, return 0
	if (a == 0 || b == 0)
	{
		lowest=0;
		return lowest;
	}
	//otherwise, find LCM
	else 
	{
		//checks which inputed integer is greater
		if(a>=b)
		{
			//finds multiples of the lower number
			for (int x=1;x<=a;x++)
			{
				//multiples the multiplier and the lower integer
				int product = x*b;
				//if the resulting number divides cleanly into the higher value return that integer (LCM)
				if(product%a==0)
				{
					return product;
				}
			}
		}
		//checks which inputed integer is greater
		if(b>=a)
		{
			//finds multiples of the lower number
			for (int x=1;x<=b;x++)
			{
				//multiples the multiplier and the lower integer
				int product = x*a;
				//if the resulting number divides cleanly into the higher value return that integer (LCM)
				if(product%b==0)
				{
					return product;
				}
			}
		}
	}
//filler
return filler;
}
//clears console
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



