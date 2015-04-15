package com.guilhebl.algo.math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find longest Prime number Of N
 * @author root
 *
 */
public class FindLongestPrimeNumberOfN {

	public static void main(String[] args) {
		System.out.println(findLongestPrimeOfN(600851475143L));
	}
	
	public static long findLongestPrimeOfN(long n) {
	    long largestPrime = -1;
		
	    List<Long> primes= new ArrayList<Long>();
	    for(long i=1;i*i<=n;i++) {
	    	if(n % i == 0) {
		    	if (isPrime(i)) {
		    		primes.add(i);
		    	}	    		    		
	    	}	    	
	    }			    
	    Collections.sort(primes);
	    largestPrime = primes.get(primes.size()-1);
	    
		return largestPrime;
	}
	
	//checks whether an int is prime or not.
	public static boolean isPrime(long n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(long i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
}
