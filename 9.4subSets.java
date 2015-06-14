/*Write a method to return all subsets of a set*/
import java.util.*;
class test{
	public static void printSubsets(int[] arr){
		System.out.println("empty");
		HashSet<String> result=new HashSet<String>();
		result=printProperSubsets(arr,arr.length-1,result);
		for (String s:result)
			System.out.println(s);
	}

	public static HashSet<String> printProperSubsets(int[] arr,int end,HashSet<String> set){
		if (end==-1){
			return set;
		}else{
			HashSet<String> tmp=(HashSet)set.clone();
			for (String s:tmp){
				s=Integer.toString(arr[end])+" "+s;
				set.add(s);
			}
			set.add(Integer.toString(arr[end]));
			return printProperSubsets(arr,end-1,set);
		}
	}
	public static void main(String[] args){
		int arr[]=new int[]{1,2,3};
		printSubsets(arr);
	}
}