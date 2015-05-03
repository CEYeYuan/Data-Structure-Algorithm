/*
Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional datastrutures?
*/
/* Hashmap review
1.need import java.util.HashMap;
2.some API:map.put(key,map.get(key)+1) This means a key-value pairs can be 
  rewritted
3.
*/
import java.util.*;
public class uniqueChar{
	public static void main (String[] args){
		String s="hel  ";
		if (checkUniqueChar(s))
			System.out.println("Distinct!");
		else
			System.out.println("Duplicates!");

		}
	
	public static boolean checkUniqueChar(String s){
		//check if one char is in the hashmap; if so, return
		//false, if not, put it into hashmap; recurse through the 
		//string
		HashMap<String,String> hash=new HashMap<String,String>();
		int length=s.length();
		for (int i=0;i<length;i++){
			if (hash.containsKey(Character.toString(s.charAt(i)))){
				return false;
			}else{
				hash.put(Character.toString(s.charAt(i)),"");
			}
		}
		return true;
	}
}