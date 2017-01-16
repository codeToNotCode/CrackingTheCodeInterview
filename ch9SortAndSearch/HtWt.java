/*
 * To find the largest possible tower of people that can be made by stacking one person on another
 * such that the height and weight of the person on top is less than the person beneath
 */

package ch9SortAndSearch;

import java.util.ArrayList;
import java.util.Collections;

public class HtWt implements Comparable
{
	private int Ht;
	private int Wt;
	
	public HtWt(int h, int w)
	{
		Ht = h;
		Wt = w;
	}
	
	
	/*
	 * Function to check whether the height and weight of the calling object and that of the object passed in the argument is same or not
	 * If the heights are not equal then only the heights will be compared and not the weights
	 * Else only the weights will be compared
	 */
	public int compareTo(Object s)
	{
		HtWt second = (HtWt) s;
		
		if(this.Ht != second.Ht)
			return ((Integer)this.Ht).compareTo(second.Ht);
		else
			return ((Integer)this.Wt).compareTo(second.Wt);
	}
	
	/*
	 * To print the height-weight pair of a single person
	 */
	public String toString()
	{
		return "("+Ht+","+Wt+")";
	}
	
	
	/* 
	 * Returns true if “this” should be lined up before “other”. Note 
	 * that it’s possible that this.isBefore(other) and 
	 * other.isBefore(this) are both false. This is different from the 
	 * compareTo method, where if a < b then b > a. 
	 */
	public boolean isBefore(HtWt other)
	{
		if( this.Ht < other.Ht && this.Wt < other.Wt)
			return true;
		else
			return false;
	}
	
	
	/*
	 * Function to initialize heights and weights of all the persons
	 */
	public static ArrayList<HtWt> initialize()
	{
		ArrayList<HtWt> items = new ArrayList<HtWt>();
		
		HtWt item = new HtWt(65, 60);		items.add(item);
		item = new HtWt(70, 150);			items.add(item);
		item = new HtWt(56, 90);			items.add(item);
		item = new HtWt(75, 190);			items.add(item);
		item = new HtWt(60, 95);			items.add(item);
		item = new HtWt(68, 110);			items.add(item);
		item = new HtWt(35, 65);			items.add(item);
		item = new HtWt(40, 60);			items.add(item);
		item = new HtWt(45, 63);			items.add(item);
		
		return items;
	}
	
	
	/*
	 * TO return the longer out of the given two sequences
	 */
	public static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2)
	{
		if ( seq1 == null )
			return seq2;
		else if ( seq2 == null )
			return seq1;
		
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}
	
	
	public static void longestIncreasingSubsequence(ArrayList<HtWt> items, ArrayList<HtWt>[] solutions, int current_index)
	{
		if( current_index >= items.size() || current_index < 0 )
			return;
		
		HtWt currentElement = items.get(current_index);
		
		//Find the longest sequence we can append our currentElement to
		ArrayList<HtWt> bestSequence = null;
		
		for(int i = 0 ; i < current_index ; i++ )
		{
			//If the currentElement is bigger than the tail element of the list: Set bestSequence to our new max
			if( items.get(i).isBefore(currentElement))
				bestSequence = seqWithMaxLength(bestSequence, solutions[i]);
		}
		
		//Append current element
		ArrayList<HtWt> newSolution = new ArrayList<HtWt>();
		if( bestSequence != null )
			newSolution.addAll(bestSequence);
		
		//Add to the existing list and recurse
		newSolution.add(currentElement);
		longestIncreasingSubsequence(items,solutions, current_index + 1);
	}
	
	
	public static ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> items)
	{
		ArrayList<HtWt>[] solutions = new ArrayList[items.size()];
		longestIncreasingSubsequence(items,solutions,0);
		
		ArrayList<HtWt> bestSequence = null;
		
		for( int i = 0 ; i < items.size() ; i++)
			bestSequence = seqWithMaxLength(bestSequence, solutions[i]);
		
		return bestSequence;
	}
	
	
	/*
	 * Function to print the solution: Longest increasing subsequence of people that can form the desired tower
	 */
	public static void printList(ArrayList<HtWt> Solution)
	{
		for( HtWt item : Solution)
			System.out.println(item.toString()+" ");
	}
	
	
	/*
	 * TO sort the persons on the basis of their heights and weights
	 * Call another function to find the largest number of people that can be used to form a tower
	 */
	public static ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items)
	{
		Collections.sort(items);
		return longestIncreasingSubsequence(items);
	}

	
	//Driver Function
	public static void main(String[] args)
	{
		ArrayList<HtWt> items = initialize();
		ArrayList<HtWt> solution = getIncreasingSequence(items);
		printList(solution);
	}
}
