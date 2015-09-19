/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
 public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)   return 0;
        Arrays.sort(nums);
        int best,diffMin;
        best=nums[0]+nums[1]+nums[2];
        diffMin=Math.abs(best-target);
        int current,diff;
        
        for(int i=0;i<nums.length-2;){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                current=nums[i]+nums[j]+nums[k];
                diff=Math.abs(current-target);
                if(diff<diffMin){
                    best=current;
                    diffMin=diff;
                }
                if(current<target){
                    do j++;
                    while(j<nums.length&&nums[j]==nums[j-1]);
                }
                else if(current==target)    return target;
                else{
                    do k--;
                    while(k>=0&&nums[k]==nums[k+1]);
                }
            }
            do i++;
            while(i<nums.length&&nums[i]==nums[i-1]);
        }
        return best;
    }
}