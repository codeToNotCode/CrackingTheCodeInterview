/*
 * To perform a fillPaint operation similar to  windows paint 
 */


package ch8Recursion;

public class FillColor 
{

	//Constants to provide the list of available colors
	public enum Color 
	{
		Black, White, Red, Yellow, Green
	}
	
	
	//Function to change the String of colors to a single alphabet
	public static String PrintColor(Color c) 
	{
		switch(c) 
		{
			case Black:
				return "B";
			case White:
				return "W";
			case Red:
				return "R";
			case Yellow:
				return "Y";
			case Green:
				return "G";
		}
		return "X";
	}
	
	
	//Function to print the screen grid with each letter representing each pixel
	public static void PrintScreen(Color[][] screen) 
	{
		for (int i = 0; i < screen.length; i++) 
		{
			for (int j = 0; j < screen[0].length; j++) 
			{
				System.out.print(PrintColor(screen[i][j]));
			}
			System.out.println();
		}
	}
	
	
	//Function to generate random numbers that will change the original grid color
	public static int randomInt(int n) 
	{
		return (int) (Math.random() * n);
	}
	
	
	//Start from an arbitrary point and keep on filling the new color untill you encounter the old color from all the directions
	public static boolean PaintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) 
	{
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) 
			return false;
		
		if (screen[y][x] == oldColor) 
		{
			screen[y][x] = newColor;
			PaintFill(screen, x - 1, y, oldColor, newColor); // left
			PaintFill(screen, x + 1, y, oldColor, newColor); // right
			PaintFill(screen, x, y - 1, oldColor, newColor); // top
			PaintFill(screen, x, y + 1, oldColor, newColor); // bottom
		}
		return true;
	}
	
	
	//Function that makes a call to the recursive function
	public static boolean PaintFill(Color[][] screen, int x, int y, Color newColor) 
	{
		if (screen[y][x] == newColor) 
			return false;
	
		return PaintFill(screen, x, y, screen[y][x], newColor);
	}
	
	
	//Driver Function
	public static void main(String[] args) 
	{
		int N = 3;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				screen[i][j] = Color.Red;

		for (int i = 0; i < 10; i++)
			screen[randomInt(N)][randomInt(N)] = Color.Green;

		PrintScreen(screen);
		PaintFill(screen, 2, 2, Color.White);
		System.out.println();
		PrintScreen(screen);
	}

}