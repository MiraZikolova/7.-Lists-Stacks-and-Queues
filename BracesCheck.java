package stacksAndQueues8.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;



public class BracesCheck {

	
	
	public static void main(String[] args) {
		Stack<Character> braces = new Stack<>();
		File myFile = new File("src/stacksAndQueues8/homework/Check.java");      //kazwame kude e file
		FileReader fr;
		try {
			fr = new FileReader(myFile);                  //Scanner - nqma nextChar() -> FileReader
			BufferedReader br = new BufferedReader(fr);     //po-optimalno izpulnenie
			int c = 0;
			boolean conflict = false;
			while((c = br.read()) != -1) {               //zapochwame da chetem    //ASCI kod
				char character = (char) c;               //casting
				if(character == '(' || character == '{' || character == '[') {
					braces.add(character);                   //autoboxing  cast kum char  (Stack<> -16 red)
				} else if (character == ')') {
					conflict = (braces.pop() != '(');
				} else if (character == '}') {
					conflict = (braces.pop() != '{');        //autounboxing obekt tip Character -> char
				} else if (character == ']') {
					conflict = (braces.pop() != '[');
				}
				
				if(conflict)
					break;          //conflict becomes true and we see that there are missmatched braces
			}
			
			
			br.close();			
			
			
			if(conflict || ! braces.isEmpty()) {                  //prowerqwa i dali nqma prekaleno mnogo skobi
				System.out.println("There are missmatched braces");
			} else {
				System.out.println("There are no missmatched braces");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}