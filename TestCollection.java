package collectionsDEMO7;
import java.util.*;

public class TestCollection {
	public static void main(String[] args) {
		ArrayList<String> collection1 = new ArrayList<String>();  //create an array list
		collection1.add("New York");                              //add elements
		collection1.add("Atlanta");
		collection1.add("Dallas");
		collection1.add("Madison");
		System.out.println("A list of cities in collection1:");
		System.out.println(collection1);                         //show the elements
		System.out.println("\nIs Dallas in collection1? " + collection1.contains("Dallas"));
		collection1.remove("Dallas");                            //left: New York, Atlanta, Madison
		System.out.println("\n" + collection1.size() + " cities are in collection1 now");    //size = 3

		Collection<String> collection2 = new ArrayList<String>();         //create a reference from type Collection
		collection2.add("Seattle");                                       //add elements
		collection2.add("Portland");
		collection2.add("Los Angeles");
		collection2.add("Atlanta");
		System.out.println("\nA list of cities in collection2:");
		System.out.println(collection2);                                    //show the elements
		ArrayList<String> c1 = (ArrayList<String>) (collection1.clone());   //copy elements, create a new array
		c1.addAll(collection2);                                             //combine the two collections
		System.out.println("\nCities in collection1 or collection2: ");
		System.out.println(c1);
		c1 = (ArrayList<String>) (collection1.clone());                     //copy elements, create a new array
		c1.retainAll(collection2);                                          //elemnts in common
		System.out.print("\nCities in collection1 and collection2: ");
		System.out.println(c1);
		c1 = (ArrayList<String>) (collection1.clone());                     //copy elements, create a new array
		c1.removeAll(collection2);                                          //just New York and Madison
		System.out.print("\nCities in collection1, but not in 2: ");
		System.out.println(c1);
	}
}