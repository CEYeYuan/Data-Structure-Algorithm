/*Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, s1 and s2. Write code to check if s2 is a 
rotation of s1 using only one call to isSubstring (e.g. "waterbottle" is a
rotation of "erbottlewat").
*/

/*
The problem itself is easy:
If a is a rotate of b, a.length==b.length and a is the subString of b+b
*/
class subString{
	public static void main(String[] args){
		String s1="bottlewater";
		String s2="erbottlewat";
		if (isRotation(s1,s2))
			System.out.println(s1+" is the rotation of "+s2+"!");
		if (isSubstring(s1,s2))
			System.out.println(s1+" is the substring of "+s2+"!");

	}

	public static boolean isSubstring(String s1, String s2){
		if (s1.length()>s2.length())
			return false;
		else{
			for (int i=0;i<=s2.length()-s1.length();i++){
				int j=0;
				for (j=0;j<s1.length();j++){
					if (s1.charAt(j)!=s2.charAt(i))
						break;
					i++;
				}
				if (j==s1.length())
					return true;
			}
			return false;
		}

	}

	public static boolean isRotation(String s1, String s2){
		return (s1.length()==s2.length()&&isSubstring(s1,s2+s2));
	}
} 
