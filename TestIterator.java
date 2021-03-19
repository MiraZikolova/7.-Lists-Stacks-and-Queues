package collectionsDEMO7;

import java.util.*;

public class TestIterator {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();       //create a collection
		collection.add("New York");                                    //add elements
		collection.add("Atlanta");
		collection.add("Dallas");
		collection.add("Madison");
		
		Iterator<String> iterator = collection.iterator();            //get an iterator(it is now at the beginning of the array)
		while (iterator.hasNext()) {                                  //are there any more elements left
			System.out.print(iterator.next().toUpperCase() + " ");
		}
		System.out.println();
		
		for (String element: collection)                             //String element acts as an iterator
			System.out.print(element.toUpperCase() + " ");
		
		System.out.println();
	}
}