/*Write a method to replace all spaces in a string with '%20'. You may assume 
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the 'true' length of the string.(Note: if 
implementing in java,pleasezy use a character array so that you can perform this 
operation in place.)

Input:"Mr John Smith	",13
Output:"Mr%20John%20Smith"

*/

/*
###
Memory Review:
Java store stuff in two separate pools of memory: stack and heap 
1.stack stores all local variables,including all parameters
2.heap store all objects, including all arrays, and all class variables('static')
*/
import java.util.*;
class replaceSpace{
	public static void main(String[] args){
		//String s="hello";
		String s="Mr John Smith     ";
		int trueLength=13;
		//char[] str=s.toCharArray();
		//System.out.println(replaceWhiteSpace(s,trueLength)+"|||end");
		System.out.println(replaceWhiteSpaceFromBack(s,trueLength)+"|||end");
	}

	public static String replaceWhiteSpace(String s,int trueLength){
		StringBuffer buffer=new StringBuffer();
		char[] str=s.toCharArray();
		int strLength=s.length();
		char[] result=new char[strLength-1];
		int j=0;

		for (int i=0;i<trueLength-1;i++){
			if (str[i]==' ' ||str[i]=='\t' ||str[i]=='\n' ){
				result[j]='%';
				result[j+1]='2';
				result[j+2]='0';
				j+=3;
			}else{
				result[j]=str[i];
				j++;
			}
		}
		while(j<strLength-1){
			result[j]=' ';
			j++;
		}
		String rs=new String(result);
		return rs;
	}

	public static String replaceWhiteSpaceFromBack(String s,int trueLength){
		char[] str=s.toCharArray();
		int whiteSpace=count(str,trueLength);
		int newTruelength=trueLength+2*whiteSpace;
		int j=trueLength-1;
		int i=newTruelength-1;
		while(j>=0){
			if (str[j]==' '||str[j]=='\t' ||str[j]=='\n'){
				str[i]='0';
				str[i-1]='2';
				str[i-2]='%';
				i-=3;
			}
			else{
				str[i]=str[j];
				i-=1;
			}
			j--;
		}
		return new String(str);

	}

	public static int count(char[] input,int trueLength){
		int result=0;
		for (int i=0;i<trueLength-1;i++){
			if (input[i]==' '||input[i]=='\t' ||input[i]=='\n')
				result++;
		}
		return result;
	}
}