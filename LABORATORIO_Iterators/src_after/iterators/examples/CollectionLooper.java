package iterators.examples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class shows different kind of loops on set of values (Collection, Set, List)
 *
 */
public class CollectionLooper {
	
	/**
	 * Print all elements inside the collection using standard for statement
	 * @param collection the collection to be printed
	 */
	void standardLoop(Collection<Something> collection) {
		int i;
		for(i=0; i<collection.size(); i++) {
			//WRONG! This method can't be implemented because Collection doesn't maintain an order for its elements
			//"I can't call something like collection.get(i) because there's no i-position.
		}
	}
	
	/**
	 * Print all elements inside the set using standard for statement
	 * @param set the set to be printed
	 */
	void standardLoop(Set<Something> set) {
		int i;
		for(i=0; i<set.size(); i++) {
			//WRONG! This method can't be implemented because Set doesn't maintain an order for its elements
			//"I can't call something like collection.get(i) because there's no i-position.
		}
	}
	
	/**
	 * Print all elements inside the list using standard for statement
	 * @param list the list to be printed
	 */
	void standardLoop(List<Something> list) {
		int i;
		for(i=0; i<list.size(); i++) {
			//OK: List (and classes that implement it) has an internal order for its elements 
			Something item = list.get(i);
			System.out.println(item);
		}
	}
	
	/**
	 * Print all elements inside the collection using standard for statement
	 * @param collection the collection to be printed
	 */
	void forEachLoop(Collection<Something> collection) {
		for(Something some:collection) {
			//OK: for-each loop does not require an order to access the items
			System.out.println(some);
		}
	}
	
	/**
	 * Print all elements inside the set using standard for statement
	 * @param set the set to be printed
	 */
	void forEachLoop(Set<Something> set) {
		for(Something some:set) {
			//OK: for-each loop does not require an order to access the items
			System.out.println(some);
		}
	}
	
	/**
	 * Print all elements inside the list using standard for statement
	 * @param list the list to be printed
	 */
	void forEachLoop(List<Something> list) {
		for(Something some:list) {
			//OK: faster than the standard for loop for lists
			System.out.println(some);
		}
	}
	
	
	/**
	 * Print all elements inside the collection using standard for statement
	 * @param collection the collection to be printed
	 */
	void iteratorLoop(Collection<Something> collection) {
		//OK: Collection interface implements Iterable interface
		Iterator<Something> it = collection.iterator();
		
		while(it.hasNext()) {
			Something item = it.next();
			System.out.println(item);
		}
	}
	
	/**
	 * Print all elements inside the collection using standard for statement
	 * @param collection the collection to be printed
	 */
	void iteratorLoop(Set<Something> set) {
		//OK: Set interface implements Collection
		Iterator<Something> it = set.iterator();
		
		while(it.hasNext()) {
			Something item = it.next();
			System.out.println(item);
		}
	}
	
	/**
	 * Print all elements inside the collection using standard for statement
	 * @param collection the collection to be printed
	 */
	void iteratorLoop(List<Something> list) {
		//OK: List interface implements Collection
		Iterator<Something> it = list.iterator();
		
		while(it.hasNext()) {
			Something item = it.next();
			System.out.println(item);
		}
	}
}
