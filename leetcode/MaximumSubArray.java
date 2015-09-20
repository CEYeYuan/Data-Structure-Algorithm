/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)    return 0;
        int max,cur;
        max=cur=nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur<0)   cur=nums[i];
            else    cur=cur+nums[i];
            if(cur>max)     max=cur;
        }
        return max;
        
    }
}