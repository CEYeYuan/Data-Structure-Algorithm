class test{
	public static void main(String[] args){
		int []arr1=new int[]{1,2,3,4,5};
		int []arr2=new int[]{6,7,8,9,10};
		int median=find(arr1,arr2);
		System.out.println("The median is "+median);
	}

	private static int find(int[] arr1,int[] arr2){
		int n=(arr1.length+arr2.length)/2;
		/*this should be the index of median if we merge two arrays in other words,this means 
		the median should be greater than equal to exactly n numbers in two array.Let's try binary
		search
		*/
		int i=
	}
}