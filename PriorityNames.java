package stacksAndQueues8.homework;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityNames {

	public static void main(String[] args) { 
		//create the two priority queues
		PriorityQueue<String> q1 = new PriorityQueue<>(Arrays.asList( 
				"George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael"));
		PriorityQueue<String> q2 = new PriorityQueue<>(Arrays.asList(
				"George" , "Katie" , "Kevin" , "Michelle" , "Ryan"));
		
		//Display the two original queues
		System.out.println("Set1: " + q1);
		System.out.println("Set2: " + q2);
		
		PriorityQueue<String> union = new PriorityQueue<>(q1);  //subirame dwete queue-ta
		union.addAll(q2);
		
		PriorityQueue<String> intersection = new PriorityQueue<>(q1);  //namirame obshtite elementi
		intersection.retainAll(q2);
		
		PriorityQueue<String> difference = new PriorityQueue<>(union);    //mahaiki obshtite elementi, shte ostanat samo tezi, koito ne se powtarqt
		difference.removeAll(intersection);
		
		System.out.println("Union of sets: " + union);
		System.out.println("Intersection of sets: " + intersection);
		System.out.println("Difference of sets: " + difference);
		
		
	}

}