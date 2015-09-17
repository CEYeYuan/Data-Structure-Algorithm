/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int result=binarySearch(nums,target-0.5,0,nums.length-1);
        return result;
    }
    private int binarySearch(int[] nums,double target,int low,int high){
        if(nums==null||nums.length==0)
            return -1;
        else if(low>=high){
            //return the first number that is greater than the target
            if(low<nums.length){
                if(target>nums[low])    return low+1;
                else    return low;
            }
            else
                return low;
        }
        else{
            int mid=(low+high)/2;
            if(nums[mid]==target)   return mid;
            else if(target>nums[mid])   return binarySearch(nums,target,mid+1,high);
            else    return binarySearch(nums,target,low,mid-1);
        }
    }
}