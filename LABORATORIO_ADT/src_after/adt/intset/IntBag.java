package adt.intset;

import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class IntBag{
	/**
	 * This class provides an ADT for sets of int. IntSet is mutable, unbounded.
	 */
	/**
	 * INVARIANT elements != null & elements
	 * contains boxed int (Integer). Elements is not sorted.
	 */
	private Vector<Integer> elements;

	/** EFFECT; initialize this to a new set, empty. */
	public IntBag() {
		this.elements = new Vector<Integer>();
	}

	/**
	 * @param: elts. REQUIRE be null. EFFECT initialize this to a new set, which
	 *         contains each element of elts; duplicated elements are not
	 *         considered.
	 */
	public IntBag(int[] elts) {
		this.elements = new Vector<Integer>();
		elts = Objects.requireNonNull(elts);
		for (int x : elts) {
			Integer y = new Integer(x);
			this.elements.addElement(y);
		}
	}

	/**
	 * Copy constructor.
	 * 
	 * @param s: a set to be duplicated EFFECT initialize this to a new set that
	 *        contains all and only the elements of s.
	 */
	@SuppressWarnings("unchecked")
	public IntBag(IntBag s) {
		s = Objects.requireNonNull(s);
		this.elements = (Vector<Integer>) s.elements.clone();
	}

	/** MODIFY this: x is added to this set */
	public void insert(int x) {
		assert (this.elements != null);
		Integer y = new Integer(x);
		this.elements.addElement(y);
		assert (this.elements.contains(y));
	}

	/**
	 * MODIFY this: x is removed to this set if x is present
	 * 
	 * @return: true if x was removed
	 */
	public boolean remove(int x) {
		assert (this.elements != null);
		Integer y = new Integer(x);
		boolean res = this.elements.remove(y);
		assert (!this.elements.contains(y));
		return (res);
	}

	/** @return: true if x is present in this */
	public boolean isIn(int x) {
		assert (this.elements != null);
		Integer y = new Integer(x);
		int i = this.indexOf(y);
		boolean res = (i >= 0);
		assert (!res || this.elements.contains(y)) : "res implies (y in elements)";
		return (res);
	}

	/**
	 * @return: the index of x if it is present in this ; return -1 if not present
	 */
	private int indexOf(Integer x) {
		assert (this.elements != null);
		for (int i = 0; i < this.elements.size(); i++) {
			if (this.elements.get(i).equals(x)) {
				return (i);
			}
		}
		return (-1);
	}

	/** @return: the number of elements in this */
	public long size() {
		assert (this.elements != null);
		return (this.elements.size());
	}

	/**
	 * @return: a random element in this
	 * @throws: EmptyIntSetException if this is empty
	 */
	public int choose() throws EmptyIntSetException {
		assert (this.elements != null);
		if (this.elements.isEmpty()) {
			throw new EmptyIntSetException();
		}
		Random randomGenerator = new Random();
		int x = randomGenerator.nextInt(this.elements.size());
		return (this.elements.elementAt(x));
	}

	/**
	 * @param s2: REQUIRE not null
	 * @return true if this and s2 contain the same set of int
	 */
	public boolean sameValues(IntBag s2) {
		s2 = Objects.requireNonNull(s2);
		Collections.sort(this.elements);// BEWARE integers are moved
		Collections.sort(s2.elements);
		boolean res = this.elements.equals(s2.elements);
		return (res);
	}
}
