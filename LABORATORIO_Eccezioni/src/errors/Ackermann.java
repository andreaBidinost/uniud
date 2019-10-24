package errors;

import java.math.BigInteger;

/*
 * La funzione di Ackermann è una funzione ricorsiva
 * che cresce molto rapidamente.
 * 
 * Si guardino i javadoc delle sottoclassi di Error.
 */


public class Ackermann {

	public static void main(String[] args) {
		BigInteger m= BigInteger.valueOf(0);
		BigInteger n= BigInteger.valueOf(0);
		System.out.print(ack(m,n));
	}
	
	public static BigInteger ack(BigInteger m, BigInteger n) {
	    return m.equals(BigInteger.ZERO)
	            ? n.add(BigInteger.ONE)
	            : ack(m.subtract(BigInteger.ONE),
	                        n.equals(BigInteger.ZERO) ? BigInteger.ONE : ack(m, n.subtract(BigInteger.ONE)));
	}
}
