
//Scholar Sun
//Array List Set
//ICS4UC1
//May 14 2016

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class DeckGUIDemoArrayList extends JFrame {
	
	static Deck deck = new Deck();
	static JComboBox b = new JComboBox();
	static JComboBox ran = new JComboBox();
	static JComboBox index = new JComboBox();

	// Constructor
	public DeckGUIDemoArrayList() {
		// Create/initialize components
		// Button Listener
		BtnListener btnListener = new BtnListener();
		// Shuffle Button
		JButton shuffleBtn = new JButton("Shuffle");
		shuffleBtn.addActionListener(btnListener);
		// Quick Sort Button
		JButton sortBtn = new JButton("Quick Sort");
		sortBtn.addActionListener(btnListener);
		// Deal Button
		JButton dealBtn = new JButton("Deal");
		dealBtn.addActionListener(btnListener);
		// Add Button
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(btnListener);
		// Search Button
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(btnListener);
		// Selection Sort Button
		JButton selsortBtn = new JButton("Selection Sort");
		selsortBtn.addActionListener(btnListener);

		// Add Labels, suit rank & index
		JLabel lbl1 = new JLabel(" Suit:");
		lbl1.setVisible(true);
		JLabel lbl2 = new JLabel(" Rank:");
		lbl2.setVisible(true);
		JLabel lbl3 = new JLabel(" Index:");
		lbl3.setVisible(true);

		// ComboBox Arrays
		String[] suitstring = { "Spades", "Hearts", "Clubs", "Diamonds" };
		String[] rankstring = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		String[] indexes = new String[52];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = Integer.toString(i + 1);
		}

		// Set ComboBoxes
		b = new JComboBox(suitstring);
		ran = new JComboBox(rankstring);
		index = new JComboBox(indexes);
		b.setSelectedIndex(3);
		ran.setSelectedIndex(12);
		index.setSelectedIndex(51);

		// Create content pane, set layout
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());

		// Draws the area
		DrawArea board = new DrawArea(600, 400);

		// Add the components to the input area.
		north.add(shuffleBtn);
		north.add(sortBtn);
		north.add(selsortBtn);
		north.add(lbl1);
		north.add(b);
		north.add(lbl2);
		north.add(ran);
		north.add(addBtn);
		north.add(searchBtn);
		north.add(lbl3);
		north.add(index);
		north.add(dealBtn);
		// Assign locations
		content.add(north, "North"); // Input area
		content.add(board, "South"); // Deck display area

		// 4... Set this window's attributes.
		setContentPane(content);
		pack();
		setTitle("Deck Demo");
		setSize(900, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center window.
	}

	// ActionListner for buttons
	class BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Deal")) {
				// Gets selected index of ComboBox
				String in = (String) index.getSelectedItem();
				int ind = Integer.parseInt(in);

				// Sends to deal method
				deck.deal(ind);
				deck.unflip();
				repaint();
			} else if (e.getActionCommand().equals("Shuffle")) {
				// Unflips and shuffles deck
				deck.unflip();
				deck.shuffle();
				repaint();
			} else if (e.getActionCommand().equals("Quick Sort")) {
				// Unflips and uses quick sort algorithm
				deck.unflip();
				deck.quickSort(0, deck.deckSize() - 1);
				repaint();
			} else if (e.getActionCommand().equals("Selection Sort")) {
				// Unflips and uses selection sort algorithm
				deck.unflip();
				deck.selectionSort();
				repaint();
			} else if (e.getActionCommand().equals("Add")) {
				// Variable declaration
				int ra = ran.getSelectedIndex();
				int su = b.getSelectedIndex();
				int cardval = 0;

				// Suits
				cardval = (su * 13) + 1;

				// Rank
				cardval = cardval + (ra);

				// Unflips
				deck.unflip();

				// Sends to add
				Card send = new Card(cardval - 1);
				deck.add(send);
				repaint();
			} else if (e.getActionCommand().equals("Search")) {
				// Variable declaration
				int ra = ran.getSelectedIndex();
				int su = b.getSelectedIndex();
				int cardval = 0;
				int object[];

				// Suits
				cardval = (su * 13) + 1;

				// Rank
				cardval = cardval + (ra);
				Card searched = new Card(cardval - 1);

				// Unflips
				deck.unflip();

				// Send to search
				object = deck.search(searched);
				repaint();
			}
		}
	}

	// Draws area
	class DrawArea extends JPanel {
		// Sets the size
		public DrawArea(int width, int height) {
			this.setPreferredSize(new Dimension(width, height));
		}

		// Draws
		public void paintComponent(Graphics g) {
			deck.show(g);
		}
	}

	// Main method
	public static void main(String[] args) {
		DeckGUIDemoArrayList window = new DeckGUIDemoArrayList();
		window.setVisible(true);
	}
}

// --------------Card Class--------------
class Card {
	// Card data fields
	private int rank;
	private int suit;
	private Image image;
	private boolean faceup;
	private static Image cardback;

	// Creates Cards
	public Card(int cardNum) {
		// Data field declaration
		rank = cardNum % 13;
		suit = cardNum / 13;
		faceup = true;
		image = null;

		// Loads File onto image and image onto card
		try {
			image = ImageIO
					.read(new File("C:/Users/ScholarLenovo/Documents/Computer Science/Works/ArrayLists/src/cards/"
							+ (cardNum + 1) + ".gif"));
			cardback = ImageIO.read(
					new File("C:/Users/ScholarLenovo/Documents/Computer Science/Works/ArrayLists/src/cards/b.gif"));

		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	// Draws the graphic, face up or down
	public void show(Graphics g, int x, int y) {
		if (faceup)
			g.drawImage(image, x, y, null);
		else
			g.drawImage(cardback, x, y, null);

	}

	// Converts the card to a string
	public String toString() {
		// Variable Declaration
		int r = this.rank;
		int s = this.suit;
		String suit, rank;

		// Check suits
		if (s == 0) {
			suit = "Spades";
		} else if (s == 1) {
			suit = "Hearts";
		} else if (s == 2) {
			suit = "Clubs";
		} else {
			suit = "Diamonds";
		}

		// Get value of rank
		rank = Integer.toString(r + 1);

		// Build string
		String card = rank + " of " + suit;
		return card;
	}

	// Rank accessor method
	public int getRank() {
		int a = this.rank;
		return a;
	}

	// Suit accessor method
	public int getSuit() {
		int a = this.suit;
		return a;
	}

	// Faceup accessor method
	public boolean getFace() {
		boolean a = this.faceup;
		return a;
	}

	// Changes face up status
	public void changeFace() {
		if (this.faceup == true) {
			this.faceup = false;
		} else {
			this.faceup = true;
		}
	}
}

// --------------Deck Class--------------
class Deck {
	// List of cards in the deck
	private ArrayList<Card> deck;

	// Default constructor;full,standard deck
	public Deck() {
		deck = new ArrayList<Card>(52);
		for (int x = 0; x < 52; x++) {
			deck.add(new Card(x));
		}
	}

	// Draws cards
	public void show(Graphics g) {
		for (int c = 0; c < deck.size(); c++) {
			// Sends to show(graphics,coordinates)
			deck.get(c).show(g, c % 13 * 20 + 150, c / 13 * 50 + 20);
		}
	}

	// Shuffles current deck
	public void shuffle() {
		// remove card at random position r and add it to the bottom of the deck
		for (int x = 0; x < 2 * deck.size(); x++) {
			// Generates a random deck index
			int r = (int) (Math.random() * deck.size());
			deck.add(deck.remove(r));
		}
	}

	// Gets deck size
	public int deckSize() {
		int a = deck.size();
		return a;
	}

	// Deals a card, returns the removed card object
	public Card deal(int a) {
		if (a <= deck.size()) {
			Card removed = deck.remove(a - 1);
			return removed;
		} else {
			System.out.println("Index Out of Bounds");
		}
		return null;
	}

	// Searches for card
	public int[] search(Card a) {
		// Variable declaration
		String input = a.toString();
		int[] searched;
		int counter = 0;
		int secondcounter = 0;

		// Checks for array size
		for (int i = 0; i < deck.size(); i++) {
			Card c = deck.get(i);
			String card = c.toString();
			if (card.equals(input)) {
				counter++;
			}
		}

		// Set array
		searched = new int[counter];
		ArrayList<Card> temp = new ArrayList<Card>(52);
		temp = deck;

		// Find the indexes of the searched object
		// Cannot compare the card values, send to string.
		String searchstr = a.toString();

		// Loops through the deck
		for (int w = 0; w < temp.size(); w++) {
			String card = temp.get(w).toString();

			// Checks if any are equal
			if (card.equals(searchstr)) {
				searched[secondcounter] = w;
				Card flip = deck.get(w);
				flip.changeFace();
				deck.remove(w);
				deck.add(w, flip);
			}
		}

		return searched;
	}

	// Quick sort recursion method
	public void quickSort(int start, int end) {
		// base case of sort is when there is an array of 1 element to sort
		if (start < end) {
			// find partition index
			int partitionIndex = Partition(start, end);
			// sort elements to the left and right of the partition
			quickSort(start, partitionIndex - 1);
			quickSort(partitionIndex + 1, end);
		}
	}

	// Finds the parts of the arrays
	private int Partition(int start, int end) {
		// Take a random pivot point, in this case the last index
		int pivot = deck.get(end).getRank();

		// set value for next partition point
		int partitionIndex = start;

		for (int i = start; i < end; i++) {
			// If there is a smaller value on the left of the pivot, swap it
			// with the right
			if (deck.get(i).getRank() <= pivot) {
				Card temp = deck.get(i);
				deck.set(i, deck.get(partitionIndex));
				deck.set(partitionIndex, temp);

				// Increments position
				partitionIndex++;
			}
		}

		// Swaps positions
		Card temp1 = deck.get(partitionIndex);
		deck.set(partitionIndex, deck.get(end));
		deck.set(end, temp1);

		// Returns the index where the left is smaller than element
		// and the right is greater than element
		return partitionIndex;
	}

	// Uses selection sort to sort the deck
	public void selectionSort() {
		Card temp;
		for (int x = 0; x < deck.size() - 1; x++) {
			// assume first index is the smallest element
			int lowPos = x;

			for (int y = x + 1; y < deck.size(); y++) {
				// Converts the card to integer value
				Card q = deck.get(y);
				Card low = deck.get(lowPos);
				int c1 = (q.getRank()) + ((q.getSuit() * 13));
				int c2 = (low.getRank()) + ((low.getSuit() * 13));

				// if there is a smaller element, change lowest position index
				if (c1 < c2)
					lowPos = y;
			}
			// swap first index with the smallest element
			temp = deck.get(x);
			deck.set(x, deck.get(lowPos));
			deck.set(lowPos, temp);
		}
	}

	// Adds a card to the end of the deck
	public void add(Card c) {
		deck.add(c);
	}

	// Unflips all the cards in the deck
	public void unflip() {
		for (int i = 0; i < deck.size(); i++) {
			Card fliperino = deck.get(i);
			// If it isn't true, flip and set
			if (fliperino.getFace() != true) {
				fliperino.changeFace();
				deck.remove(i);
				deck.add(i, fliperino);
			}
		}
	}
}
