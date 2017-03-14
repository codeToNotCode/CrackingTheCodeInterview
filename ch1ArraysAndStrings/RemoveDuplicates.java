package ch1ArraysAndStrings;

import java.util.LinkedHashMap;
import java.util.Set;

public class RemoveDuplicates
{
	public static String remDups(String s)
	{
		if( s == null )
			return "Empty String";
		if(s.length() < 2 )
			return "No duplicates";
		
		LinkedHashMap map = new LinkedHashMap();
		
		for( int i = 0 ; i < s.length() ; i++ )
			if( !map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), i);
		
		Set keys = map.keySet();
		String st = "";
		
		for( Object obj : keys)
			st+= obj;
		
		return st;
	}
	
	public static void main(String[] args)
	{
		System.out.println(remDups("Prasandeep"));
	}
}
