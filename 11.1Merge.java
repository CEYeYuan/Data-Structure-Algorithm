/* 
11.1 You are given sorted arrays, A and B, where A has a large enough buffer at the end 
to hold B. Write a method to merge B into A in sorted order.
*/
class test{

	private static int[] merge(int[] a,int[] b,int aSize){
		int index=aSize+b.length-1;
		int indexA=aSize-1;
		int indexB=b.length-1;
		int tmp;
		for(int i=indexB;i>=0;i--){
			if(b[i]>=a[indexA]){
				a[index]=b[i];
				index--;
			}else{
				while(indexA!=-1&&a[indexA]>b[i]){
					
					shift(a,indexA,index-indexA);
					indexA--;
					index--;
				}
				a[index]=b[i];
				index--;
			}
		}
		return a;
	}

	private static void shift(int[] input,int index,int offset){
		input [index+offset]=input[index];
	}
	private static String arrToString(int[] input){
		String s="[";
		for (int i=0;i<input.length;i++){
			s=s+input[i]+" ";
		}
		s=s+"]";
		return s;
	}
	public static void main(String[] args){
		int[] arr1=new int[10];
		arr1[0]=1;
		arr1[1]=3;
		arr1[2]=4;
		int[] arr2=new int[]{0,2,6,7};
		int[] result=merge(arr1,arr2,3);
		System.out.println(arrToString(result));
	}
}