package iterators.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class shows how to (and how not) perform a loop on a list modifying the list itself
 *
 */
public class LoopModifier {

	/**
	 * Perform a for loop and change each element 
	 * @param list the list to be visited
	 */
	void doStandardLoopAndModify(List<Something> list) {
		int i;
		for(i=0; i<list.size(); i++) {
			//OK: change something inside the element of the list
			Something item = list.get(i);
			item.changeContent();
		}
	}
	
	/**
	 * Perform a for-each loop and change each element 
	 * @param list the list to be visited
	 */
	void doForEachLoopAndModify(List<Something> list) {
		for(Something some: list) {
			//WRONG!: for each loop can't change the original item
			//"some" object is just a copy of the value contained inside the list
			
			some.changeContent(); //doesn't modify the list item, just the copy of it
		}
	}
	
	/**
	 * Perform a loop using Iterators and change each element 
	 * @param list the list to be visited
	 */
	void doIteratorLoopAndModify(List<Something> list) {
		Iterator<Something> it = list.iterator();
		
		while(it.hasNext()) {
			Something item = it.next();
			item.changeContent();
		}
	}
	
	/**
	 * Perform a for loop and modify the list during the loop.
	 * An item could be removed from the list with probability 50%.
	 * @param list the list to be changed
	 */
	void doStandardLoopAndRemove(List<Something> list) {
		int i;
		for(i=0; i<list.size(); i++) {
			//OK: each step evaluate the size and perform the step if there are any item left
			if(Math.random() > 0.5) {//50% of probability
				Something item = list.get(i);
				list.remove(item);	
			}
		}
	}
	
	/**
	 * Perform a for loop and modify the list during the loop.
	 * An item could be removed from the list with probability 50%.
	 * @param list the list to be changed
	 */
	void doForEachLoopAndRemove(List<Something> list) {
		for(Something some: list) {
			if(Math.random() > 0.5) {//50% of probability
				//WRONG: a Collection can't be modified inside a for-each statement 
				//see https://stackoverflow.com/questions/9806421/concurrentmodificationexception-when-adding-inside-a-foreach-loop-in-arraylist
				list.remove(some);
			}
		}
	}
	
	/**
	 * Perform a for loop and modify the list during the loop.
	 * An item could be removed from the list with probability 50%.
	 * Another item could be added to the list with probability 50%.
	 * @param list the list to be changed
	 */
	void doIteratorLoopAndRemove(List<Something> list) {
		Iterator<Something> it = list.iterator();
		
		while(it.hasNext()) {
			it.next();
			if(Math.random() > 0.5) {//50% of probability
				//OK: Iterator can remove an item itself and from the original list
				it.remove(); //the method is called on the iterator object, not on the list
			}
			
			if(Math.random() > 0.5) {//50% of probability
				//WRONG: list can't be directly modified during an iterated loop
				//Iterator throws a ConcurrentModificationException if list is directly modified
				list.add(new Something());
			}
		}
	}
	
	/**
	 * LIFE LESSON:
	 * - Avoid usage of standard for loop over a collection (except for some good reason...)
	 * - User for-each loop just for reading a Collection (no modification) 
	 * - Use iterator to change list content and to remove elements from a list
	 * - Don't modify a list directly inside a for-each and an iterated loop: use a standard for loop instead
	 */
}

