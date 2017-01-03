/*
 * To make a given number in binary a substring of another number at given index
 */	

package ch5BitManipulations;

public class MSubstringN
{
	public int updateBits(int n , int m , int i , int j)
	{
		/*
		 * ~0 gives all 1s
		 * ~0 is equal to -1 in decimal. So when you convert -1 (decimal) to binary : you get all 1s
		 * To convert -1 to binary - First write positive 1 in binary, then take 2s complement of it to arrive at your result
		 */
		int max = ~0;
		
		
		/*
		 * To keep all 1s only till position j, after that make all 0s
		 * eg - max = 1111 1111 and j = 5 . So the output of the below expression will be 1110 0000
		 * Number of 0s will be equal to the value of j
		 */
		int left = max - ((1 << j) - 1);
		
		
		/*
		 * To make all 1s to occur uptill the position i
		 * eg - if i = 3 . So the output of the below expression will be 0000 0111
		 * Number of 1s will be equal to the value of i
		 */
		int right = ((1 << i) - 1);
		
		
		/*
		 *  TO have all 1s except the positions between i and j
		 *  eg - if j = 5 and i = 3 , the output of the below expression will be 1110 0111
		 *  5 -3 = 2 . So there will be only 2 positions with 0s rest all will be 1s
		 */
		int mask = left | right ;
		
		
		/*
		 * Clear(make zero) all the positions in n starting from i to j
		 * Shift m by i positions
		 * OR the above outputs to make m a substring of n
		 */
		return ( n & mask ) | ( m << i);
	}
	
	public static void main(String[] args)
	{
		MSubstringN bits = new MSubstringN();
		
		System.out.println(bits.updateBits(256, 7, 5, 3));
		System.out.println(~0);
	}
}
