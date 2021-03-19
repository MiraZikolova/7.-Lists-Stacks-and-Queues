package collectionsLinkedList7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiLinkedLists {
	public static void main(String[] args) {
	LinkedList<Integer> numbers = new LinkedList<>();       //prawim swurzan spisuk,koito sudurja integers
	System.out.println("Please enter five numbers:");
	Scanner sc = new Scanner(System.in);                    //suzdawame scanner

//	System.out.println(numbers);
//	Collections.sort(numbers);
//	System.out.println(numbers);
//	Collections.sort(numbers, Collections.reverseOrder());
//	System.out.println(numbers);
//	Collections.shuffle(numbers);
//	System.out.println(numbers);

	
	
	//create the frame
	JFrame frame = new JFrame("Numbers");
	frame.setSize(350,200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//create a main pannel
	JPanel mainPanel= new JPanel();
	frame.add(mainPanel);
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //iskame da sa vertikalno podredeni = y axis
		
	//create text area to display the results
	JTextArea numbersArea = new JTextArea(); 
	
	JTextField inputNumbers = new JTextField();
	inputNumbers.addActionListener(new ActionListener() {      //detect enter
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Integer number = Integer.parseInt(inputNumbers.getText());
			if(! numbers.contains(number)) {      //s metoda contains proverqwame dali se sudurja chisloto weche; wrushta boolean stoinost
				numbers.add(number);              //samo ako chisloto go nqma
			}
			inputNumbers.setText("");  //da se izchistwa textowoto pole sled kato wuwedem element
			numbersArea.setText(numbers.toString());            //prewrushtame spisuka w text i go izkarwame w text area
			System.out.println(numbers);
		}
	});
	
	mainPanel.add(inputNumbers);
	

//	JTextArea numbersArea = new JTextArea();    //mestim,zashtoto realno trqbwa da dostupim pole predi 62 red
	numbersArea.setEditable(false);
	mainPanel.add(numbersArea);
	
	JButton sortButton = new JButton("Sort");
	sortButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Collections.sort(numbers);                  //wikame static Collections, podawame parametur numbers i sortirame
			numbersArea.setText(numbers.toString());    //za da izliza w text area sled natiskane na butona
		}
	});
	mainPanel.add(sortButton);
	
	JButton reverseSortButton = new JButton("Reverse Sort");
	reverseSortButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Collections.sort(numbers, Collections.reverseOrder()); //podawame dopulnitelen Comparator, koito obrushta reda
			numbersArea.setText(numbers.toString());               //za da izliza w text area sled natiskane na butona
		}
	});
	mainPanel.add(reverseSortButton);
	
	JButton shuffleButton = new JButton("Shuffle");
	shuffleButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Collections.shuffle(numbers);                   //podawame parametur numbers i razburkwame
			numbersArea.setText(numbers.toString());        //za da izliza w text area sled natiskane na butona
		}
	});
	mainPanel.add(shuffleButton);
	
	frame.setVisible(true)  ;     //puska ni samiq GUI
}
	
}

