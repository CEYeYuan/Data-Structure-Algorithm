/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
public class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
         int len=arr1.length+arr2.length;
         if(len%2==1)//odd
            return findkth(arr1,arr2,0,0,len/2+1);
         else{
             double ret=0.5* findkth(arr1,arr2,0,0,len/2+1)+0.5* findkth(arr1,arr2,0,0,len/2);
             return ret;
         }
        
    }
    
    private int findkth(int[] arr1,int[] arr2,int astart,int bstart, int k){
         //k starts with 1, k==1 means find the minimum element
         if(astart>=arr1.length)
            return arr2[bstart+k-1];
         if(bstart>=arr2.length)
            return arr1[astart+k-1];
         if(k==1)
            return Math.min(arr1[astart],arr2[bstart]);
         int a=(astart+k/2-1<arr1.length) ? arr1[astart+k/2-1]:Integer.MAX_VALUE;
         int b=(bstart+k/2-1<arr2.length) ? arr2[bstart+k/2-1]:Integer.MAX_VALUE;
         if(a<b){
             return findkth(arr1,arr2,astart+k/2,bstart,k-k/2);
         }else{
             return findkth(arr1,arr2,astart,bstart+k/2,k-k/2);
         }
    }
}