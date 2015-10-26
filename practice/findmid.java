class test{
	public static void main(String[] args){
		int []arr1=new int[]{1,2,3,4,5};
		int []arr2=new int[]{6,7,8,9,10};
		double median;
		int len=arr1.length+arr2.length;
		if(len%2==1){
			median=find(arr1,arr2,0,arr1.length-1,0,arr2.length-1,len/2);
		}else{
			median=find(arr1,arr2,0,arr1.length-1,0,arr2.length-1,len/2-1)*0.5+find(arr1,arr2,0,arr1.length-1,0,arr2.length-1,len/2)*0.5;
		}
		System.out.println("The median is "+median);
	}

	private static int find(int[] a,int[] b,int aStart,int aEnd,int bStart,int bEnd,int k){
		
		int alen,blen;
		alen=aEnd-aStart+1;
		blen=bEnd-bStart+1;
		if(alen<=0)//a is empty
			return b[bStart+k];
		if(blen<=0)
			return a[aStart+k];
		if(k==0){
			return (a[aStart]<=b[bStart])?a[aStart]:b[bStart];
		}
		int aindex=(alen)/(blen+alen)*k+aStart;
		int bindex=k-(alen)/(blen+alen)*k-1+bStart;
		if(a[aindex]>b[bindex]){
			k-=bindex-bStart+1;
			aEnd=aindex;
			bStart=bindex+1;
		}else{
			k-=aindex-aStart+1;
			bEnd=bindex;
			aStart=aindex+1;
		}
		return find(a,b,aStart,aEnd,bStart,bEnd,k);
	}
}