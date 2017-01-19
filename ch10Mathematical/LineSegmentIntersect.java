/*
 * To check whether the line segments pq and rs intersect or not
 * 
 * Algorithm : Conditions for intersection :
 * 1)GENERAL CASE : If any one of the below sub conditions is true, then the line segments will intersect
 * 		A) Orientations of p,q,r and p,q,s are different
 * 		B) Orientations of r,s,p and r,s,q are different
 * 
 * 2)SPECIAL CASE : If both the above orientations are same (0) , it means all the points line on the same line. 
 * 	Then will intersect if a point on one line segment lies on the other line segment. Four cases arise and lines will intersect if any one of the case evaluates to true:
 * 		A) Point r lies on the line segment pq
 *		B) Point s lies on the line segment pq
 *		C) Point p lies on the line segment rs 
 *		D) Point q lies on the line segment rs
 *
 *	If the Special case also evaluates to false, then we can say that the two line segments do not intersect at all
 */
package ch10Mathematical;

public class LineSegmentIntersect
{
	
	/*
	 * TO check whether the Point r lies on the line segment pq or not
	 */
	public boolean onLineSegment(Point p, Point r, Point q)
	{
		if( r.x >= Math.min(p.x, q.x) && r.x <= Math.max(p.x, q.x) &&
				r.y >= Math.min(p.y, q.y) && r.y <= Math.max(p.y, q.y)	) 
			return true;
		return false;
	}
	 
	
	/*
	 * To find the orientation formed by line segment pq and qr
	 * 0 - Collinear
	 * 1- Anticlockwise
	 * 2- Clockwise
	 */
	public int orientation(Point p, Point q, Point r)
	{
		int val = (q.y - p.y)*(r.x-q.x) - (r.y-q.y)*(q.x-p.x);
		
		if( val == 0 )
			return 0;
		
		if (val < 0 )
			return 1 ;
		else
			return 2;
	}
	
	
	
	/*
	 * TO check whether the line segments pq and rs intersect or not
	 * To check for line segment intersection you need 4 points
	 * 1 line segment is made of 2 points
	 */
	public boolean doIntersect(Point p, Point q, Point r,Point s)
	{
		int o1 = orientation(p,q,r);
		int o2 = orientation(p,q,s);
		int o3 = orientation(r,s,p);
		int o4 = orientation(r,s,q);
		
		//General Case
		if( o1 != o2 && o3 != o4 )
			return true;
		
		if( o1 == 0 && onLineSegment(p, r, q))
			return true;
		
		//If points p,q,s are collinear and s lies on line segment pq
	
		if( o2 == 0 && onLineSegment(p, s, q))
			return true;
		
		//If points r,s,p are collinear and p lies on line segment rs
		if( o3 == 0 && onLineSegment(r, p, s))
			return true;
	
		//If points r,s,q are collinear and q lies on line segment rs
		if( o4 == 0 && onLineSegment(r, q, s))
			return true;
						
		//If all the cases fail, the two line segments do not intersect
		return false;
	}
	
	
	public static void main(String[] args)
	{
		LineSegmentIntersect lsi = new LineSegmentIntersect();
		
		Point p1 = new Point(1,1);		Point q1 = new Point(10,1);
		Point r1 = new Point(1,2);		Point s1 = new Point(10,2);
		System.out.println("Do the given line segments intersect?\n"+((lsi.doIntersect(p1, q1, r1, s1)) ? "YES" : "NO"));

		Point p = new Point(10,0);		Point q = new Point(0,10);
		Point r = new Point(0,10);		Point s = new Point(10,10);
		
		System.out.println("Do the given line segments intersect?\n"+((lsi.doIntersect(p, q, r, s)) ? "YES" : "NO"));
	
		Point p2 = new Point(-5,-5);		Point q2 = new Point(0,0);
		Point r2 = new Point(1,1);			Point s2 = new Point(10,10);
		
		System.out.println("Do the given line segments intersect?\n"+((lsi.doIntersect(p2, q2, r2, s2)) ? "YES" : "NO"));
	
	}
}
