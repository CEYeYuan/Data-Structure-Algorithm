/*
given an input array, let all the negative number occurred before positive number while keep 
their relative position
*/
class split{
	public static void main(String[] args){
		int[] arr=new int[]{1,-1,5,-2,24,10,-39};
		split(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}


 	} 
 	public static void split(int [] arr){
 		if(arr=0||arr.length<=1)
 			return;
 		else{
 			int neg,pos;
 			neg=0;
 			pos=arr.length-1;
 			for(int i=0;i<arr.length;i++){
 				if(arr[i]<0){
 					neg++;
 					continue;
 				}
 				else{
 					int j=i+1;
 					while(j<&&arr[j]>0)
 				}	
 			}
 		}
 	}

 	private static void swap(int[]arr,int i,int j){
 		int tmp=arr[i];
 		arr[i]=arr[j];
 		arr[j]=tmp;
 	} 
}