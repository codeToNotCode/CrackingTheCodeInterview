/*
 * TO print all the prime numbers upto a given number n
 * Algorighm used - Sieve of Eratosthenes
 * Time complexity - O(nloglogn)
 */

package ch10Mathematical;

import java.util.ArrayList;
 
public class PrimesUpToN {
	
	public ArrayList<Integer> sieve(int n)
	{
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        
        for(int i=0;i<=n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int j = 2; j*p <= n; j++)
                    prime[j*p] = false;
            }
        }
         
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
            	primes.add(i);
        }
        return primes;
    }

	
	//Driver Function
	public static void main(String[] args)
	{
		PrimesUpToN p = new PrimesUpToN();
		
		ArrayList<Integer> primes = p.sieve(30);
		System.out.println();
		for(Integer i : primes )
			System.out.print(i + " ");
	}
}

