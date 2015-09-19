/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
 public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums==null||nums.length<4)   return list;
        for(int i=0;i<nums.length-3;){
           for(int j=i+1;j<nums.length-2;){
               int mid=j+1;
               int high=nums.length-1;
               while(mid<high){
                       int cur=nums[i]+nums[j]+nums[mid]+nums[high];
                       if(cur<target)            mid++;
                       else if(cur>target)      high--;
                       else{
                           ArrayList<Integer> tmp=new ArrayList<Integer>();
                           tmp.add(nums[i]);
                           tmp.add(nums[j]);
                           tmp.add(nums[mid]);
                           tmp.add(nums[high]);
                           list.add(tmp);
                           do mid++;
                                while(mid<nums.length&&nums[mid]==nums[mid-1]);
                           do high--;
                                while(high>=0&&nums[high]==nums[high+1]);
                       }
               }
               do  j++;
                     while(j<nums.length&&nums[j]==nums[j-1]);
           }
            do  i++;
                     while(i<nums.length&&nums[i]==nums[i-1]);
        }
        return list;
    }
}