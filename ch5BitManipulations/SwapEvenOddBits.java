/*
 * To swap the even and odd bits in the binary representation of a given number with minimum number of instructions
 * Total number of instructions carried out = 5
 */


package ch5BitManipulations;

public class SwapEvenOddBits
{
	/*
	 * To swap the odd and even bits of a given integer number
	 */
	public int swapBits(int num)
	{
		/*
		 * 0xaaaaaaaa - represents hexadecimal equivalent of 32 bits of A (1010) 
		 * 0x55555555 - represents hexadecimal equivalent of 32 bits of 5 (0101)
		 * To swap the odd and even bits, we first mask the binary equivalent of the given number with the above values
		 * We mask all the odd bits with 0xaaaaaaaa and all the even bits with 0x55555555
		 * We then do a right shift operation on the first( makes the odd bits even now) 
		 * And a left shift operation( makes the even bits odd now)  on the second expression
		 * Last step is to perform an OR operation on the result
		 */
		return ( ((num & 0xaaaaaaaa) >> 1) | ( ( num & 0x55555555) << 1 ));
	}
	
	public static void main(String[] args)
	{
		SwapEvenOddBits seob = new SwapEvenOddBits();
		System.out.println(seob.swapBits(9));
	}
}
