/*
 * To count the number of bits required to convert one number to another
 * eg To convert 31 to 14, you need to change 2 bits
 * The simple solution to this problem is to use the XOR operator
 * XOR gives 1 only if the bits are different. This is the solution we want
 * The number of different bits is actually the number of bits required to be changed to convert one number to another
 */


package ch5BitManipulations;

public class BitsForConversion
{
	/*
	 * To count the number of different bits using the XOR operator
	 */
	public int numberOfBitsToChange(int num1, int num2)
	{
		//A variable to store the number of different bits
		int count = 0;
		
		/*
		 * num1 XOR num2 gives us a number in decimal form with only those bits that are not common in num1 and num2
		 * We need to count the number of bits that make up the decimal number c
		 * c >> 1 is right shift or divide by 2 operation
		 * count += c & 1 does the counting in binary
		 */
		for( int c = num1^num2 ; c!=0 ; c = c>>1)
			count += c & 1;
		
		return count;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		BitsForConversion bfc = new BitsForConversion();
		System.out.println(bfc.numberOfBitsToChange(7, 8));
	}
}
