/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current=m+n-1;
        m--;
        n--;
        
        while((m>=0)&&(n>=0)){
            if(nums1[m]>=nums2[n]){
                nums1[current]=nums1[m];
                m--;
            }else{
                nums1[current]=nums2[n];
                n--;
            }
            current--;
        }
        if(current<0 || m>=0)
            return;
        else{
            while(current>=0){
                nums1[current]=nums2[n];
                current--;
                n--;
            }
        }
        
    }
}