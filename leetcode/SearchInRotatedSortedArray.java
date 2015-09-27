/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int search(int[] nums, int target) {
        int first=findfirst(nums,0,nums.length-1);
        //return first;
        //System.out.println(first);
        return binarySearch(nums,0,nums.length-1,first,target);
    }
    
    private int findfirst(int[] nums,int l,int h){
        int mid=(l+h)/2;
        if(l>=h){
            if(l>=nums.length)   return l-1;
            if(h<0)    return l;
            if(nums[l]>nums[h]) return h;
            else    return l;
           
        }
        if(nums[mid]>nums[h])   return findfirst(nums,mid+1,h);
        else   return findfirst(nums,l,mid);
    }
    
    private int binarySearch(int[] nums,int l,int h,int first,int target){
        int low=(first+l)%nums.length;
        int high=(first+h)%nums.length;
        int m=(l+h)/2;
        int mid=(first+m)%nums.length;
        if(l>h){
           return -1;
        }
        else if(nums[mid]>target)    return binarySearch(nums,l,m-1,first,target);
        else if(nums[mid]<target)    return binarySearch(nums,m+1,h,first,target);
        else    return mid;
       
    }
}