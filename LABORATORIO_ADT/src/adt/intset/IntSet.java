package adt.intset;

import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class IntSet {
	/**
	 * This class provides an ADT for sets of int. IntSet is mutable, unbounded.
	 * Class overview: public IntSet() public IntSet(int [] elts) public
	 * IntSet(IntSet s) public void insert(int x) public boolean remove(int x)
	 * public boolean isIn(int x) private int indexOf(Integer x) public int choose()
	 * throws EmptyIntSetException public boolean sameValues(IntSet s2)
	 */
	/**
	 * ABSTRACTION FUNCTION: the set is constituted by all the integers that are
	 * represented in this.elements. Elements is not sorted. INVARIANT elements !=
	 * null & elements contains no duplicates & elements contains boxed int
	 * (Integer).
	 */
	private Vector<Integer> elements;

	/**
	 * EFFECT; initialize this to a new set, empty.
	 */
	public IntSet() {
		this.elements = new Vector<Integer>();
	}

	/** @param: elts, the int's to be added to the set
	* EFFECT initialize this to a new set, which contains each element
	* of elts; duplicated elements are not considered.
	* @throws NullPointerException if elts is null
	*/
	public IntSet(int [] elts){
		if (elts == null){
			throw new NullPointerException("elts should not be null");
		}
		this.elements = new Vector<Integer>();
		for (int x:elts){
			Integer y = new Integer(x);
			if (!this.elements.contains(y)){
				this.elements.addElement(y);
			}
		}
	}

	/**
	 * Copy constructor.
	 * 
	 * @param s: a set to be duplicated EFFECT initialize this to a new set that
	 *        contains all and only the elements of s.
	 * @throws NullPointerException if s is null
	 */
	@SuppressWarnings("unchecked")
	public IntSet(IntSet s) {
		if (s == null) {
			throw new NullPointerException("s should not be null");
		}
		this.elements = (Vector<Integer>) s.elements.clone();
	}

	/**
	 * MODIFY this: x is added to this set if x is not present
	 */
	public void insert(int x) {
		Objects.requireNonNull(this.elements);
		Integer y = new Integer(x);
		if (!this.elements.contains(y)) {
			this.elements.addElement(y);
		}
		assert (this.elements.contains(y));
	}

	/**
	 * MODIFY this: x is removed from this set if x is present
	 * 
	 * @return: true if x was removed
	 */
	public boolean remove(int x) {
		Objects.requireNonNull(this.elements);
		Integer y = new Integer(x);
		boolean res = this.elements.remove(y);
		assert (!this.elements.contains(y));
		return (res);
	}

	/**
	 * @return: true if x is present in this
	 */
	public boolean isIn(int x) {

		Objects.requireNonNull(this.elements);
		Integer y = new Integer(x);
		int i = this.indexOf(y);
		boolean res = (i >= 0);
		assert (!res || this.elements.contains(y)) : "res implies (y in elements)";
		return (res);
	}

	/**
	 * @return: the index of x if it is present in this ; return -1 if not present
	 */
	private int indexOf(int z) {
		Objects.requireNonNull(this.elements);
		Integer x = new Integer(z);
		for (int i = 0; i < this.elements.size(); i++) {
			if (this.elements.get(i).equals(x)) {
				return (i);
			}
		}
		return (-1);
	}

	/**
	 * @return: the number of elements in this
	 */
	public long size() {
		Objects.requireNonNull(this.elements);
		return (this.elements.size());
	}

	/**
	 * @return: a random element in this
	 * @throws: EmptyIntSetException if this is empty
	 */
	public int choose() throws EmptyIntSetException {
		Objects.requireNonNull(this.elements);
		if (this.elements.isEmpty()) {
			throw new EmptyIntSetException();
		}
		Random randomGenerator = new Random();
		int x = randomGenerator.nextInt(this.elements.size());
		return (this.elements.elementAt(x));
	}

	/**
	 * @param s2: the set to be compared to this
	 * @return true if this and s2 contain the same set of int MODIFY this and s2 by
	 *         sorting their elements 3
	 * @throws NullPointerException if s2 is null
	 */
	public boolean sameValues(IntSet s2) {
		Objects.requireNonNull(this.elements);
		if (s2 == null) {
			throw new NullPointerException("s2 should not be null");
		}
		Collections.sort(this.elements);// BEWARE integers are moved
		Collections.sort(s2.elements);
		boolean res = this.elements.equals(s2.elements);
		return (res);
	}
}