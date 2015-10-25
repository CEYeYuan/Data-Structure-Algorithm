class test{
/*a sequence of consecutive number, one is missing, find the missing one. 
Use Gussi theorem is trival, we can try exclusive or.
The property of xor is that if two numbers(bits) are the same,they gets cancelled
out, if that one only occurred once,it gets reserved. 
*/
	public static void main(String[]args){
		int[] arr=new int[]{1,2,3,4,6,7,8};
		int i=findMissing(arr,1,8);
		System.out.println("The missing number is "+i);
	}
	private static int findMissing(int[]arr,int start,int end){
		int bit=0;
		for(int i=start;i<=end;i++){
			bit^=i;
		}
		for(int i=0;i<arr.length;i++){
			bit^=arr[i];
		}
		return bit;
	}
}