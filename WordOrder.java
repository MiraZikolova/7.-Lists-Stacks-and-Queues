package collectionsLinkedList7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class WordOrder {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();     //suzdawame ArrayList ot string (w nachaloto e prazen)
		File myObj = new File("filename.txt");
		
		try {             //The try statement allows you to define a block of code to be tested for errors while it is being executed.
			Scanner myReader = new Scanner (myObj);    //suzdawame obekt ot klasa Scanner
			while(myReader.hasNextLine()) {
			String line = myReader.nextLine();
			String lineWords[] = line.split("[\\s.,]+");   //razdelq dumite i gi slaga w masiv pri " " , .  regular expression/search pattern
			words.addAll(Arrays.asList(lineWords));        //dobawq novite dumi
		}
		myReader.close();
	} catch(FileNotFoundException e) { //The catch statement allows you to define a block of code to be executed, if an error occurs in the try block
		try {
			myObj.createNewFile();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	}
		Collections.sort(words);      //izpolzwame static method Collections s parametur ArrayList words
		System.out.println(words);
}
}