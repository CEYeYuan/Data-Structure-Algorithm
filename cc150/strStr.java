/* Return the position of the first occurrence of string target in string source,
or -1 if target is not part of source .*/

public class strStr{
	public static void main(String[] args){

	}
	public static int strStr(String source,String target){
		for (int i=0;i<source.length();i++){
			for (int j=0;j<target.length();j++){
				if (source.charAt(i)!=target.charAt(j))
					break;
			}
			return -1;
		}
	}
}