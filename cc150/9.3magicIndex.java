/*A magic index in an array A[0...n-1] is defined to be an index such that A[i]=i.
Given a sorted array, write a method to find a magic index, if one exists, in 
array A.
Follow up
What if the values are not distinct */
class test{
	public static void printIndex(int[] arr,int start){
		if (start>=arr.length/*|| if duplicates are not allowed arr[start]>start*/)
			return;
		else{
			if (arr[start]==start)
				System.out.println(start);
			printIndex(arr,start+1);
		}


	}

	public static void main (String[] args){
		int[] arr=new int[]{-3,1,2,4,4};
		printIndex(arr,0);
	}
}