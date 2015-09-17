/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(target>nums[nums.length-1]||target<nums[0])
        {
            int []result=new int[2];
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        else{
            int []result=new int[2];
            int start=binarySearch(nums,target-0.5,0,nums.length-1) ;
            int end=binarySearch(nums,target+0.5,0,nums.length-1)-1;
            if(start<nums.length&&nums[start]==target)
            	//test if the target is in the array
                return new int[]{start,end};
            else
                return new int[]{-1,-1};
        }
    }
    
    private int binarySearch(int[]nums, double target,int low,int high){
        if(nums==null||nums.length==0)
            return -1;
        else if(low>=high){
        	//return the first index that should be greater than target
            if(low<=nums.length-1){
                if(target>nums[low])    return low+1;
                else        return low;
            }
            else
                return low;
        }
            
        else{
            int mid=(low+high)/2;
            if(target==nums[mid])    return mid;
            else if(target>nums[mid])    return binarySearch(nums,target,mid+1,high);
            else    return binarySearch(nums,target,low,mid-1);
        }
    }
}