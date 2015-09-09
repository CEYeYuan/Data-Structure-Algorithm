/* Implement a method to perform basic string compression using the counts of 
repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
If the "compressed" string would not be smaller than the original string, your 
method should return the original string. You can assume the string has only 
upper and lower case letters.(a-z).
*/
class stringCompression{
	public static void main(String[] args){
		String s="aaaaaaaaeaccdeddzzy";
		System.out.println(strCompression(s));

	}


	public static String strCompression(String input){
		StringBuffer buffer=new StringBuffer();
		int flag=1;
		int i=0;
		while (i<input.length()-1){
			//has next and equal to the next
			while (i<input.length()-1&&input.charAt(i)==input.charAt(i+1)){
				i++;
				flag++;
			}
			buffer.append(Character.toString(input.charAt(i))+Integer.toString(flag));
			flag=1;
			i++;
		}
		if (input.charAt(input.length()-1)!=input.charAt(input.length()-2))
			buffer.append(Character.toString(input.charAt(input.length()-1))+Integer.toString(1));
		if (buffer.toString().length()<input.length())
			return buffer.toString();
		else
			return input;
	}
}