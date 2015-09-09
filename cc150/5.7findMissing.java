/*An  array A contains all the integers from 0 to n, except for one number which 
is missing. In this problem, we cannot access an entire integer in A with a single 
operation. The elments of A are represented in binary, and the only operation we can
use to access them is "fetch" the jth bit of A[i]",which takes constant time. write
code to find the missing integer. Can you do it in O(n) time ?
--- if we can get access to all the elements, we can just sum them all up, then use
Gauss's theorem, substract the total value, then we can get the missing number 
immediately, this takes O(n) time
--- Alternatively we can still add up all the digits to get the original value, which
will take log(n)n time
---The best approach is we get the number  digit by digit, first get the least significant
 digtits by sum up all the lowest digits; then second least blabla until we got the 
 most significant digit. This takes n+1/2*n+1/4*n... which is linear time  */
 import java.util.*;
 class test{
 	public static int result;
 	public static int findBit(int input,int digit){
 		// if digit==0, return the least significant bit
 		int mask=1;
 		mask=mask<<digit;
 		return mask&input;
 	}
 	public static ArrayList<Integer> turnIntoArrList(int[] input){
 		ArrayList<Integer> result=new ArrayList<Integer>();
 		for (int i:input){
 			result.add(i);
 		}
 		return result;
 	}
 	public static int findMissing(ArrayList<Integer> input,int n,int column){
 		if ((1<<column)>n){
 			return result;
 		}
 		else{
 			ArrayList<Integer> recursion0=new ArrayList<Integer>();
 			ArrayList<Integer> recursion1=new ArrayList<Integer>();
 			for (int i:input){
 				if (findBit(i,column)==0)
 					recursion0.add(i);
 				else
 					recursion1.add(i);
 			}
 			int size0=recursion0.size();
 			int size1=recursion1.size();
 			int size=size0+size1;
 			if ((size%2==0) && (size1<size0)){
 				result+=1<<column;
 				findMissing(recursion1,n,column+1);
 			}
 			else if ((size%2==1) && (size0>size1)){
 				result+=1<<column;
 				findMissing(recursion1,n,column+1);
 			}
 			else{
 				findMissing(recursion0,n,column+1);
 			}
 			return result;
 		}
 	}
 		
 	
 	public static void main (String[] args){
 		int[] arr=new int[]{5,1,2,4,3,9,6,7,8,0};
 		ArrayList<Integer> arrList=turnIntoArrList(arr);
 		int result=findMissing(arrList,10,0);
 		System.out.println("The missing element in that array is "+result);
 	}
 }
