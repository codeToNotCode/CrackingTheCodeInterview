/*
 * TO find Least Common Multiple of all the integers given in an array
 * LCM(a,b) =  (a*b)/GCD(a,b)
 * LCM(a,b,c) is not equal to (a*b*c)/GCD(a,b,c)
 */


package ch10Mathematical;

public class LCM
{
	
	/*
	 * TO find the LCM of the given list of integers
	 * Use the above mentioned formula to find LCM
	 */
	public int findLCM(int[] A)
	{
		//Create an object of GCD class to use its findGCD() method
		GCD gcd = new GCD();
		
		int lcm = A[0];
		
		for(int i = 1 ; i < A.length ; i++)
			lcm = (lcm*A[i])/gcd.findGCD(lcm,A[i]);
		
		//return the lcm
		return lcm;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		LCM lcm = new LCM();
		int A[] = {2,7,3,9,4};
		
		System.out.println(lcm.findLCM(A));
	}
}
