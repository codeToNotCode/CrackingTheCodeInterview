/*
 * To find all the subsets of a given set using recursion
 * The basic algorithm is to start with an empty set
 * Use binary tree structure for recursion
 * Grow the tree on the left using only cloning operation
 * Grow the tree on the right by adding the next element
 * The leaves of the binary tree will contain all the subsets of the given set of integers
 */


package ch8Recursion;

import java.util.ArrayList;

public class FindAllSubsetsRecursion
{

	/*
	 * To create a clone set of the input
	 * Clone set always gets added to the left side
	 */
	public ArrayList<Integer> cloneSet(ArrayList<Integer> input)
	{
		ArrayList<Integer> clone = new ArrayList<Integer>();
		
		for( int i = 0; i < input.size() ; i++ )
		{
			clone.add(input.get(i));
		}
		
		return clone;
	}
	
	
	/*
	 * to find all the subsets using recursion
	 * After each recursive step, you go down a level
	 * When last level is reached, you get all the subsets of the given set
	 */
	public void findSubsets(ArrayList<ArrayList<Integer>> allSubsets, ArrayList<Integer> set, int currIndex)
	{
		//Base case: If all the elements of a given set have been considered for all the possible subsets
		if( currIndex == set.size() )
			return;
		
		//Need to get size in advance
		//Since adding new sets to allSubsets will increase its size dynamically
		int allSubsetsSize = allSubsets.size();
		ArrayList<Integer> newSet;
		
		//For each set - allSubsets[i] in allSubsets
		//1. Create new set by adding element placed at currIndex in the given set
		//2. add this newly created set to allSubsets
		for( int i = 0 ; i < allSubsetsSize ; i++)
		{
			//Create a clone of the current element towards the left
			newSet = cloneSet(allSubsets.get(i));
			
			//Add the next element towards the right
			newSet.add(set.get(currIndex));
			
			//Add the newly formed set to the entire allsubsets
			allSubsets.add(newSet);
		}
		
		//Include next element from given set in allSubsets to carry out recursion
		findSubsets(allSubsets, set, currIndex + 1);
	}
	
	
	/*
	 * Find all subsets of a given set starting from an empty set
	 */
	public ArrayList<ArrayList<Integer>> findAllSubsets(ArrayList<Integer> set)
	{
		//Create a variable to store all the subsets of a given set
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		
		//Add empty set to all possible subsets
		allSubsets.add(new ArrayList<Integer>());
		
		//Use empty set to generate all possible subsets of a given set using recursion
		findSubsets(allSubsets, set, 0);
		
		//Return all subsets of the given set
		return allSubsets;
	}
	
	//Driver Function
	public static void main(String[] args)
	{
		FindAllSubsetsRecursion fasr = new FindAllSubsetsRecursion();
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		for(int i = 1; i<=4; i++)
			set.add(i);
		
		ArrayList<ArrayList<Integer>> allSubsets = fasr.findAllSubsets(set);

		// only 2^n-1 subsets would be printed. Empty subset is not printed.
        for (int i = 0; i < allSubsets.size(); i++)
        {
            ArrayList<Integer> tempSet = allSubsets.get(i);
            for (int j = 0;  j < tempSet.size(); j++)
            {
                System.out.print(tempSet.get(j) + ", ");
            }
            System.out.print("\n");
        }
	}
}
