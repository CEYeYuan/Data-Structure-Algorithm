/* Given two strings, write a method to decide if one is a permutation of 
the other */
import java.util.*;
public class permutation{
	public static void main(String[] args){
		String s1="hello";
		String s2="heloo";
		if (permutation(s1,s2))
			System.out.println("Is permutation!");
		else
			System.out.println("Is not permutation!");
	}
	public static Boolean permutation (String s1, String s2){
		HashMap<String,Integer> hash=new HashMap<String,Integer>();
		if (s1.length()!=s2.length())
			return false;

		else{
			for (int i=0;i<s1.length();i++){
				if(hash.containsKey(Character.toString(s1.charAt(i))))
					hash.put(Character.toString(s1.charAt(i)),
					hash.get(Character.toString(s1.charAt(i)))+1);
				else
					hash.put(Character.toString(s1.charAt(i)),1);
			}

			for (int i=0;i<s2.length();i++){
				if (!hash.containsKey(Character.toString(s2.charAt(i))))
					return false;
				else{
					if (hash.get(Character.toString(s2.charAt(i)))==1){
						hash.remove(Character.toString(s2.charAt(i)));
					}else{
						hash.put(Character.toString(s2.charAt(i)),
						hash.get(Character.toString(s2.charAt(i)))-1);
					}

				}
			}

			return true;
		}
	}
}