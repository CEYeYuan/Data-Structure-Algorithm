/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
 public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        if(nums==null||nums.length<3)   return list;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;){
        	//fix the first one , use o(n) alg determine the remaining two
            int mid=i+1;
            int high=nums.length-1;
            while(mid<high){
                if(nums[i]+nums[mid]+nums[high]<0)  mid++;
                else if (nums[i]+nums[mid]+nums[high]>0)    high--;
                 else{
                    ArrayList<Integer> tmp=new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[mid]);
                    tmp.add(nums[high]);
                    list.add(tmp);
                    do mid++;
                    while(mid<nums.length&&nums[mid-1]==nums[mid]) ;
                    do high--;
                    while(high>0&&nums[high+1]==nums[high]) ;
                }
            }
            do i++;
            while(i<nums.length&&nums[i]==nums[i-1]);
        
        }
        return list;
    }
}