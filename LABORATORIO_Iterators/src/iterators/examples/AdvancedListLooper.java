package iterators.examples;

import java.util.List;
import java.util.ListIterator;

/**
 * This class shows the advantages of a ListIterator over a simple Iterator.
 * ListIterator exists just for List and sub-classes. *
 */

class AdvancedListLooper {
	
	void performAdvancedLoop(List<Something> list) {
		ListIterator<Something> lItr = list.listIterator();
		
		ListIterator<Something> lItr2 = list.listIterator(5);//I can specify the starting position
		
		//I can access list items in normal "Iterator" way
		while(lItr.hasNext()) {
			doSomething(lItr.next());
		}
		
		//I can access list items going back
		while(lItr2.hasPrevious()) {
			doSomething(lItr.previous());
		}
		
		lItr = list.listIterator();
		//I can remove an element to the list passing through the ListIterator (as well as Iterator)
		while(lItr.hasNext()) {
			lItr.next();
			if(Math.random() > 0.5) {
				lItr.remove();
			}
		}
		
		lItr = list.listIterator();
		//I can replace an item with another one
		while(lItr.hasNext()){
			lItr.next();
			Something newItem = new Something();
			lItr.set(newItem);
		}
		
		lItr = list.listIterator();
		//I can add an element to the list passing through the ListIterator
		while(lItr.hasNext()){
			lItr.next();
			if(Math.random() > 0.5) {
				Something newItem = new Something();
				lItr.add(newItem);
			}
		}
		
	}

	private void doSomething(Something next) {
		//Just for example
	}
}
