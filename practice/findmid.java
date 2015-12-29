class test{
	public static void main(String[] args){
		int []arr1=new int[]{2,3,4};
		int []arr2=new int[]{1};
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
		//find the (k+1)th element in two array, in other word, greater than k element 

		//if(a.length>b.length)
		//	find(b,a,bStart,bEnd,aStart,aEnd,k);
		
		int alen,blen;
		alen=aEnd-aStart+1;
		blen=bEnd-bStart+1;
		if(alen<=0)//a is empty
			return b[bStart+k];
		if(blen<=0)
			return a[aStart+k];
		if(k==1){
			return Math.min(a[aStart],b[bStart]);
		}
		int aindex=(alen-1)/(blen+alen-1)*k+aStart;
		int bindex=k-(aindex-aStart+1)+bStart;
		System.out.println("aindex= "+aindex+" bindex= "+bindex);
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