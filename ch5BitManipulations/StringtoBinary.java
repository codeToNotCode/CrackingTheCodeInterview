/*
 * To convert a given string into its binary equivalent
 * 0.5 = 0.1
 * 0.25 = 0.01
 * 0.125 = 0.001
 * 0.0625 = 0.0001
 * So: 0.8125 = 0.5 + 0.25 + 0.0625 = 0.1 + 0.01 + 0.0001 = 0.1101
 */


package ch5BitManipulations;

public class StringtoBinary
{
	public String printBinary(String str)
	{
		
		/*
		 * The below statement extracts the integer part from the given string
		 * Substring(0,indexOf('.')) extracts "7612" from "7612.1245"
		 * Integer.parseInt() converts the extracted string "7612" into an int value
		 */
		int intPart = Integer.parseInt(str.substring(0,str.indexOf('.')));
		
		/*
		 * The below statement extracts the decimal part from the given string
		 * Substring(indexOf('.'), str.length()) extracts "0.1245" from "7612.1245"
		 * Double.parseDouble() converts the extracted string "0.1245" into a decimal value
		 */
		double decPart = Double.parseDouble(str.substring(str.indexOf('.'),str.length()));
		System.out.println(intPart);
		System.out.println(decPart);
		
		
		/*
		 * To convert the integer part into its decimal equivalent
		 * Declare an empty string because we will merge this string with the decimal part
		 */
		String intString = "";
		//keep executing the while loop until the intPart remains greater than 0
		while(intPart > 0)
		{
			//Find and store the remainder of dividing intPart by 2
			int remainder = intPart % 2;
			
			//The below statement performs right shift on intPart by 1 ie - Divide the intPart by 2
			intPart >>= 1;
			
			//update the intString with each execution of the while loop
			intString += remainder ;
		}
		
		//To write the intString thus formed in the correct order
		StringBuilder b = new StringBuilder(intString);
		intString = b.reverse().toString();
		
		System.out.println(intString);
		
		//Declare a stringbuffer to store the decimal part as a string
		StringBuffer decString = new StringBuffer();
		
		/*
		 * TO convert the decimal part into its binary equivalent
		 * Decimals that are multiples of 25 will be converted to binary. rest is not possible
		 * eg - .25 in binary is equal to .01 whereas .24 will result in an infinite number of binary digits
		 */
		while(decPart > 0)
		{
			//Return an error if the decimal part is not a multiple of 25
			if( decString.length() > 32 )
				return "ERROR";
			
			/*
			 * Multiply the decPart by 2 and store it in a new variable r
			 * if r >= 1 , append 1 to the finaly binary equivalent 
			 * else append 0
			 * update the decPart accordingly
			 */
			double r = decPart * 2;
			if( r >= 1)
			{
				decString.append(1);
				decPart = r - 1;
			}
			else
			{
				decString.append(0);
				decPart = r;
			}
		}
		
		//Convert the stringbuffer decString into a string and return
		return intString + "." + decString.toString();
		
	}
	
	//Driver Function
	public static void main(String[] args)
	{
		StringtoBinary stb = new StringtoBinary();
		System.out.println(stb.printBinary("6.15625"));
	}
}
