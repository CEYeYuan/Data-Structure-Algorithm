/*
Implement a function void reverse(char*str) in C or c++ which reverses 
a null-terminated string
*/

//Use String buffer to avoid expensive string operation
//swap/stack 
import java.util.*;
public class reverse{
	public static void main(String args[]){
		String s="hello";
		String reversed=reverseCharArray(s);
		System.out.println(reversed);
	}

	public static String reverse(String s){
		Stack st=new Stack();
		for (int i=0;i<s.length();i++){
			st.push(Character.toString((s.charAt(i))));
		}
		//System.out.println(st);
		StringBuffer word=new StringBuffer();
		while(st.empty()!=true){
			word.append(st.pop());
		}
		return word.toString();
	}

	public static String reverseCharArray(String s){
		char content[]=s.toCharArray();
		for (int i=0;i<content.length/2;i++)
			swap(content,i,content.length-i-1);
		StringBuffer newstr=new StringBuffer();
		for(int i=0;i<content.length;i++)
			newstr.append(Character.toString(content[i]));
		return newstr.toString();
	}


	public static char[] swap(char[] arr,int i,int j){
		char tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		return arr;
	}
}