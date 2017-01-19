/*
 * To find the type of orientation formed by making line segments from 3 points - p, q and r
 * The different types of possible orientations are - collinear, clockwise and anticlockwise
 * Let pq form 1 line segment and qr form the the 2nd line segment
 * Let slope of line segment 1 be s1 and slope of 2nd line segment be s2
 * If s1 is equal to s2 - Line segments are collinear
 * if s1 is less than s2 - Line segments have anticlockwise orientation
 * If s1 is greater than s2 - Line segments have clockwise orientation
 * 
 * Line segment is formed using 2 Points . So 2 line segments will be formed using 4 points
 * But to check orientation of one line segment with another, 2 points from 1st line segment and 1 point from the other line segment is enough
 * Hence the use of only 3 points for finding orientation and not 4
 * 
 * Follow the below link for further explanation 
 * http://www.geeksforgeeks.org/orientation-3-ordered-points/
 */

package ch10Mathematical;

public class Point
{
	static double epsilon = 00000.1;
	int x,y;

	public Point(int xCoordinate, int yCoodinate)
	{
		x = xCoordinate;
		y = yCoodinate;
				
	}
		
	/*
	 * Function to return the orientation formed by given line segments
	 * Returns 0 - Collinear
	 * Returns 1 - Anticlockwise 
	 * Return 2 - Clockwise	
	 */
	public static int orientation(Point p, Point q, Point r)
	{
		//Direct formula that comes from slope1 - slope 2 . The sign depends only on the numerator
	    int val = (q.y - p.y) * (r.x - q.x) -
	              (q.x - p.x) * (r.y - q.y);
	 
	    if (val == 0) return 0;  // colinear
	 
	    return (val < 0)? 1: 2; // clock or counterclock wise
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		Point p = new Point(0,0);
		Point q = new Point(4,4);
		Point r = new Point(2,1);
		
		int orientation = orientation(p,q,r);
		
		if ( orientation == 0 )
			System.out.println("Collinear");
		else
			System.out.println((orientation == 1) ? "Anticlockwise":"Clockwise" );
	}
}
