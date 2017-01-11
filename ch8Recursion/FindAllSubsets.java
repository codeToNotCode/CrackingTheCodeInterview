/*
 * To Find all the subsets of a given set
 * Using bit manipulations
 */

package ch8Recursion;
import java.util.*;

public class FindAllSubsets
{
	
	/*
	 * To find the individual subsets of a given set of elements
	 */
	public ArrayList<Integer> getSubset(int x, ArrayList<Integer> set)
	{
		//Create an Arraylist of integers to store a new subset
		ArrayList<Integer> subset = new ArrayList<Integer>();
		
		int index = 0;
		
		//Add only those numbers to the set which have a one in their binary equivalent
		for( int i = x; i>0 ; i >>= 1)
		{
			if( (i & 1) == 1 )
			{
				subset.add(set.get(index));
			}
			index++;
		}
		
		//Return the subset thus formed
		return subset;
	}
	
	
	/*
	 * To find all the subsets of a given set of integers
	 * The arraylist contains set of subsets which is returned
	 */
	public ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set)
	{
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		
		//Total number of subsets of a particular set is always 2^n
		int totalSubsets = 1 << set.size();
		
		//calculate individual subsets and keep on adding them to the overall set
		for(int i = 0 ; i < totalSubsets ; i++ )
		{
			//Call the getSubset method to calculate one particular subset
			ArrayList<Integer> subset = getSubset(i, set);
			
			//Add the newlly found subset to the bigger set
			allSubsets.add(subset);
		}
		
		//Return the set containing all the subsets
		return allSubsets;
	}
	  
	//Driver Function
	public static void main(String[] args) 
	{
		FindAllSubsets fas = new FindAllSubsets();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 3; i++) 
		{
			list.add(i);
		}
		
		ArrayList<ArrayList<Integer>> subsets2 = fas.getAllSubsets(list);
		System.out.println(subsets2.toString());		
	}

}