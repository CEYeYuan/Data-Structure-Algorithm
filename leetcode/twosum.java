/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2


buggy version: can not handle [0,4,3,0] since hashmap does not allow duplicates

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],i+1);
        }
         for(int i=0;i<nums.length;i++){
            if(hs.get(target-nums[i])!=null){
                result[0]=i+1;
                result[1]=hs.get(target-nums[i]);
                if(result[0]>result[1]){
                    int buffer=result[0];
                    result[0]=result[1];
                    result[1]=buffer;
                }
            }
            
        }
        return result;
    }
}

*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],i+1);
        }
         for(int i=0;i<nums.length;i++){
            if(hs.get(target-nums[i])!=null){
                result[0]=i+1;
                result[1]=hs.get(target-nums[i]);
                if(result[0]==result[1])
                    continue;
                // in case target==current; in other words, not two different indices
                if(result[0]>result[1]){
                    int buffer=result[0];
                    result[0]=result[1];
                    result[1]=buffer;
                }
                 return result; 
            }
          
         }
         return result;
    }
}