
//Set Six - String Manipulation
//Scholar Sun
//February 28 2016
//ICS4UC1

import java.util.Scanner;
import java.util.Random;

public class SetSix {public static void main(String[]args)	//Main Method
{
	 Scanner sc = new Scanner(System.in);
	 char input;
	 //Runs Menu Program
	 do
	 {
		 //Output Menu Screen
		 System.out.println("Set Six - String Manipulation");
		 System.out.println("---------------------------");
		 System.out.println("1. Palindrome");
		 System.out.println("2. ShiftCode");
		 System.out.println("3. Cryptocode");
		 System.out.println("4. Quit");
		 //Input decisions 
		 input = sc.nextLine ().charAt(0);
	 
	 		//Runs if input equals one
	 		if (input == '1')
	 		{
	 			clear();
	 			driverpalin();
	 			System.out.println("Hit Enter Twice to Return to Menu");
	 			sc.nextLine();
	 			sc.nextLine();
	 			clear();
	 		}
	 		//Runs if input equals two
	 		else if (input == '2')
	 		{
	 			clear();
	 			drivershift();
	 			sc.nextLine();
	 			sc.nextLine();
	 			clear();
	 		}
	 		//Runs if input equals three
	 		else if (input == '3')
	 		{
	 			clear();
	 			drivercrypto();
				System.out.print("Hit Enter Twice To Return To Menu");
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
	 //Closes program if input is equal to four, continues program otherwise
	 while (input != '4');
	}// Main Method End
																						
		// Method for program "palindrome"
		//Global Variables
		public static String stitch;
		public static Boolean correct;
		public static boolean palindrome(String accepted) 
		{
			//Initializes Scanner
			Scanner sc = new Scanner (System.in);
			//Length of input
			int length = accepted.length();
				//Loops for the length of input
				for (int x =0; x<length;x++)
					{
						//Separates string into separate characters
						char part = accepted.charAt(x);
						//converts everything to string and lower case
						String strpart = Character.toString(part);
						String lowera = strpart.toLowerCase();
						//runs through method alphabet to remove punctuation, spaces etc.
						boolean returned = alphabet(lowera);
							//If the returned is true, the String is stitched together to make a complete string. 
							if (returned==true)
							{
								//First stitch only
								if (x==0)
									{
										stitch = lowera +"";
									}
								//Adds on the rest of the Strings
								else
									{
										stitch = stitch + lowera;
									}
							}
					}
			//Finds the length of the stitched string
			int stitchlength = stitch.length();
			//initializes counter
			int anocounter=0;	
			//Runs a loop for half the length of the stitched string,(Checking for Palindrome)
			for (int x =0; x<stitchlength/2;x++)
					{
						//Variable declaration
						char first;
						char last = 'a';
						int counter = stitchlength; 
						//splits the string into the first letter and last
						first = stitch.charAt(x);
						//On first run
						if(x==0)
						{
							last = stitch.charAt(counter-(1));
						}
						//On second and consecutive runs
						else if(x>0)
						{
							last = stitch.charAt(counter-(x+1));
						}
						//from last letter to second last to third etc...
						counter = counter - x;
							//If the letter is equal add to counter
							if(first == last)
								{
									anocounter++;
								}
					}
				//if the counter equals the length divided by half, it is a palindrome
				if (anocounter == stitchlength/2)
					{
						correct = true;
					}
				//if not, equals false
				else
					{
						correct = false;
					}
			//Output	
			return correct;
		}
		//Method that checks if it is a letter of alphabet or number
		public static boolean alphabet(String a) 
		{	
			//Variable declaration
			String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			//Is the accepted value contained inside the alphabet?
			if (alphabet.contains(a))
				{
					//If so, return true
					return true;
				}
			else
				{
					//If it isnt return false
					return false; 
				}
		}

		// Method for program "ShiftCode"
		public static String shiftcode(int input, String accept) 
		{
			//Declares the string without punctuation or spaces
			String how = accept.toUpperCase();
			//Declares length
			int length = how.length();
			//Initialize variable
			String howstitch = null;
				//Separates the String to individual characters
				for(int x =0; x<length; x++)
				{
					//Isolates character
					char part = how.charAt(x);
					//Converts character to ASCII value (int)
					int partval = (int) part;
					//Adds the shifted value to the int
					if(partval>90||partval<65)
					{
						
					}
					else{
					 partval = partval+input;
					
					
						//Checks if the value is greater than 'Z' and subtracts/adds accordingly
						do{
						//If greater than Z
						if (partval>90)
							{
								//Wraps the alphabet around
								partval=partval-26;
							}
						//If smaller than A
						if(partval<65)
							{
								//Wraps alphabet around (other direction)
								partval=partval+26;
							}
						}while(partval>90||partval<65);
					}
					//Converts the ASCII value back to a character
					char newchar = (char) partval;
					//Converts the character to a string
					String newstring = Character.toString(newchar);
						//Only applicable on first loop, starts the stitching process
						if (x==0)
							{
								howstitch = newstring;
							}
						//Adds the character to the String after shift
						else
							{
								howstitch =howstitch  + newstring;
							}
				}
			return howstitch;
		}

		// method for program "CryptoCode"
		public static String alphascram;
		public static String crypto(String message) 
		{
			//Initializes alphabet string
			String alphascram=null;
			//Counter Declaration
			int y = 52;
				//Loops to make random 
				for(int x =0; x<y;x++)
				{
					//Initializes random
					Random rand = new Random();
					//generates lower case letters
					char scram = (char)(rand.nextInt(26)+'a');
					//generates upper case letters
					char scram2 = (char)(rand.nextInt(26)+'A');
					//converts to string
					String lower = Character.toString(scram);
					String upper = Character.toString(scram2);
					//Makes upper or lower case order random
					int uporlow =(int)(Math.random()*2)+1;
					//Upon first loop, give the alphabet some character values
					if(x==0)
						{
							//if random equals one, give a lower case value
							if(uporlow == 1)
								{
									alphascram = lower;
								}
							//if random equals two, give an upper case value
							else if(uporlow == 2)
								{
									alphascram = upper;
								}
						}
					//After first loop, runs this
					if(x>0)							
						{
						//if random equals one, give a lower case value	
							//lower case value
							if(uporlow == 1)
								{
									//checks if it has been repeated, if not add it 
								if(alphascram.contains(lower)==false)
									{
										alphascram = alphascram+lower;
									}								
									//if it has been repeated, dont add and increase loop by one
								else
									{
										y++;
									}
								}
							//upper case value
							else if(uporlow == 2)
								{
								//checks if it has been repeated, if not add it 	
								if(alphascram.contains(upper)==false)
									{
										alphascram = alphascram+upper;
									}									
								//if it has been repeated, dont add and increase loop by one
								else
									{
										y++;
									}
								}
						}
					}
				//Declares the current alphabet, unscrambled
				String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
				//Gives the length of the input an int variable
				int length = message.length();
				//Initializes the coded message
				String secret =null;
				//Runs the program for every letter of the inputed message
				for(int x = 0; x<length;x++)
					{
						//Separates the characters 
						char part = message.charAt(x);
						//Converts the character to string
						String partstr = Character.toString(part);
						//This decision makes sure it is a letter of the alphabet
						if(alphabet.contains(partstr))
							{
								//Gives the location of the character, relative to the normal alphabet
								int location = alphabet.indexOf(partstr);
								//Gets the character from the scrambled alphabet, based on the location
								char charscram = alphascram.charAt(location);
								//Converts the gathered character to string
								String newscram = Character.toString(charscram);
								//Starts building the completed String
								//Runs on first loop
								if(x==0)
									{
										secret= newscram;
									}
								//Runs on consecutive loops
								else if (x>0)
									{
										secret = secret+newscram;
									}
							}
						//If the character is not part of the alphabet, just print it
						else
							{
							//Adds the character to the code
							//Runs of first loop
							if(x==0)
									{
										secret= partstr;
									}
							//Runs on consecutive loops
							else if (x>0)
								{
									secret = secret+partstr;
								}
							}
					}
				//Outputs
				System.out.println("The scrambled alphabet is: "+ alphascram);
				System.out.println("The original alphabet is: abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
				return secret;
		}
		
		//Driver method for palindrome
		public static void driverpalin()
		{
			//Inputs String
 			Scanner sc = new Scanner(System.in);
			System.out.println("Please input a string to check");
 			String palin = sc.nextLine();
 			//Outputs true or false palindrome
 			boolean ouipalin = palindrome(palin);
 			System.out.println(ouipalin);
		}
		
		//Driver method for shift code
		public static void drivershift()
		{
			Scanner sc = new Scanner(System.in);
			//Input an int and string for shift code method
 			System.out.println("Please input the amount you want to shift by");
 			int a = sc.nextInt();
 			System.out.println("Please input a string to shift");
 			sc.nextLine();
 			String b = sc.nextLine();
 			//Get the shifted message and output
 			String shifted = shiftcode(a,b);
 			System.out.print(b + " shifted by "+ a +" is: "+ shifted);
			System.out.println("");
			System.out.print("Hit Enter Twice To Return To Menu");
		}
		
		//Driver method for crypto
		public static void drivercrypto()
		{
			Scanner sc = new Scanner(System.in);
			//Input string to input and encrypt
 			System.out.println("Please input message to encrypt");
 			String message = sc.nextLine();
 			//Send to crypto method
 			String crypted = crypto(message);
 			//Output crypted message 
 			System.out.println(message+" in the secret code is:" +crypted);
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

