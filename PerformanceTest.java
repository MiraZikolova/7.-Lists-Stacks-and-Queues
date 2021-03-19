package collectionsLinkedList7;

import java.util.LinkedList;

public class PerformanceTest {
	
	public static void main (String[] args) {
		LinkedList<Integer> numbers = new LinkedList<>();//prawim si swurzan spisuk ot integeri
		
		//cikul, koito se izwurtqwa mil puti
		for (int i = 0; i < 5_000_000; i++) {
			numbers.add(i);    //dobawqme stoinostta i kum swurzaniq spisuk
			
		}
		
		int a = 0; 
		//obhojdame swurzaniq pisuk s iterator
//		for( Integer number : numbers) {
//			//izwejdame chislata w consolata
//			a = number;
//		}
		
		//obhojdame swurzaniq spisuk s get(index)
		for (int i = 0; i < 5_000_000; i++) {
			a = numbers.get(i);
			
		}
		System.out.print(a);
	}

}
