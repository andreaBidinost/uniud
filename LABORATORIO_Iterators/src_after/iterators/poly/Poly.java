package iterators.poly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * This class provides an ADT for polynomials with integer not null coefficients
 * and with non negative exponents: c_0+c_1*x+c_2*x^2+... . Poly is immutable,
 * unbounded. The empty poly is 0=0*x^0.
 */
public class Poly {
	/**
	 * a record that represents a single term of the poly: c * x^e
	 */
	private class PolynomialTerm implements Cloneable {
		int coeff;
		int exponent;

		PolynomialTerm(int c, int e) {
			this.coeff = c;
			this.exponent = e;
		}

		/**
		 * Copy constructor
		 * 
		 * @param cpe: REQUIRE not null
		 */
		PolynomialTerm(PolynomialTerm ce) {
			ce = Objects.requireNonNull(ce);
			this.coeff = ce.coeff;
			this.exponent = ce.exponent;
		}
	}

	/**
	 * INVARIANT terms = the list of terms; there is no relation between index of
	 * the term with exponent. There can be terms with c=0.
	 */
	private Vector<PolynomialTerm> terms;

	/**
	 * @return: a new zero (empty) poly .
	 */
	public Poly() {
		terms = new Vector<PolynomialTerm>();
	}

	/**
	 * @param c: the coefficient
	 * @param n: the exponent
	 * @return: a new Poly c*x^n if c!=0; otherwise the zero Poly
	 * @Throws NegativeExponentException when n<0.
	 */
	public Poly(int c, int n) throws NegativeExponentException {
		if (n < 0) {
			throw new NegativeExponentException();
		}
		terms = new Vector<PolynomialTerm>();
		if (c != 0) {
			PolynomialTerm ce = new PolynomialTerm(c, n);
			terms.addElement(ce);
		}
	}

	/**
	 * Copy constructor.
	 * 
	 * @param p: REQUIRE not null
	 */
	public Poly(Poly p) {
		terms = new Vector<PolynomialTerm>();

		for (PolynomialTerm pt : p.terms) {
			PolynomialTerm newTerm = new PolynomialTerm(pt);
			terms.add(newTerm);
		}
	}

	/**
	 * PRODUCER
	 * 
	 * @param p: the poly to be added to this; REQUIRE not null.
	 * @return a new poly that is this+p
	 */
	public Poly add(Poly p) {
		Poly newPoly = new Poly();
		int newDegree = Math.max(p.degree(), this.degree());

		for (int i = 0; i <= newDegree; i++) {

			int newCoefficient = p.coefficient(i) + this.coefficient(i);

			if (newCoefficient != 0) {
				PolynomialTerm newTerm = new PolynomialTerm(newCoefficient, i);
				newPoly.terms.add(newTerm);
			}
		}

		return newPoly;
	}

	/**
	 * @return the largest exponent in this with non zero coeff or 0 if this is the
	 *         zero poly
	 */
	public int degree() {
		assert (this.terms != null);
		if (this.terms.isEmpty()) {
			return (0);
		}
		int highest = 0;
		for (int i = 0; i < this.terms.size(); i++) {
			PolynomialTerm cpe = this.terms.get(i);
			if (cpe.exponent > highest) {
				highest = cpe.exponent;
			}
		}
		return (highest);
	}

	/**
	 * @param n: an exponent.
	 * @return the coefficient of the term in this that has exponent n; possibly 0
	 */
	public int coefficient(int n) {
		assert (this.terms != null);
		Iterator<PolynomialTerm> it = this.terms.iterator();
		while (it.hasNext()) {
			PolynomialTerm cpe = it.next();
			if (cpe.exponent == n) {
				return (cpe.coeff);
			}
		}
		return (0);
	}

	/**
	 * @return the poly -(this)
	 */
	public Poly minus() {
		Poly newPoly = new Poly();

		for (PolynomialTerm term : this.terms) {
			PolynomialTerm newTerm = new PolynomialTerm(-term.coeff, term.exponent);
			newPoly.terms.add(newTerm);
		}

		return newPoly;
	}

	/**
	 * PRODUCER
	 * 
	 * @param p: the poly to be multiplied to this; REQUIRE not null.
	 * @return a new poly that is this*p
	 */
	public Poly mul(Poly p) {
		Poly newPoly = new Poly();

		for (int i = 0; i <= p.degree(); i++) {
			for (int j = 0; j <= degree(); j++) {
				int actualCoeff = coefficient(j);
				int otherCoeff = p.coefficient(i);

				int newCoeff = actualCoeff * otherCoeff;
				if (newCoeff != 0) {
					PolynomialTerm newTerm = new PolynomialTerm(newCoeff, i + j);
					newPoly.terms.add(newTerm);
				}
			}
		}

		return newPoly;
	}

	public String toString() {
		assert (this.terms != null);
		StringBuffer s = new StringBuffer();
		Iterator<PolynomialTerm> it = this.terms.iterator();
		while (it.hasNext()) {
			PolynomialTerm cpe = it.next();
			s.append(String.format("+%d*x^%d", cpe.coeff, cpe.exponent));
		}
		return (s.toString());
	}

	// produce un iteratore sul polinomio this
	// che consente di "estrarre" i singoli termini di this
	// che hanno coefficiente diverso da 0
	// ad es. se it e' un tale iteratore su 2x^3+4x^6 allora
	// it.next() -> 2x^3
	// it.next() -> 4x^6
	public Iterator<Poly> termIterator()  {
		List<Poly> nonZeroTerms = new ArrayList<Poly>();
		
		try {
			for(PolynomialTerm term:this.terms) {
				if(term.coeff != 0) {
					Poly newPoly = new Poly(term.coeff, term.exponent);
					nonZeroTerms.add(newPoly);
				}
			}
		}catch (NegativeExponentException nee) {
			assert false : "this cannot happen";
		}

		return nonZeroTerms.iterator();
	}

	/**
	 * @param p not null
	 * @return the result of symbolic differentiation of a poly
	 * @Throws NullPointerException if p==null
	 */
	static public Poly differentiate(Poly p) {
		Objects.requireNonNull(p);
		Poly q = new Poly();
		try {
			Iterator<Poly> startingIterator = p.termIterator();
			while(startingIterator.hasNext()) {
				Poly oldTerm = startingIterator.next();
				int oldDegree = oldTerm.degree();
				if(oldDegree != 0) {
					int oldCoeff = oldTerm.coefficient(oldDegree);
					Poly derivatedTerm = new Poly(oldCoeff * oldDegree, oldDegree-1);
					q.add(derivatedTerm);
				}
			}
			
		} catch (NegativeExponentException nee) {
			assert false : "this cannot happen";
		}
		return (q);

	}

}
