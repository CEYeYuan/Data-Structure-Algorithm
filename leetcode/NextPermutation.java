/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        /*
        for the number like **2431->3421->3124, we start from the last digit, as long as the digits are in the ascending order, we are fine. until we reach the first digits that breaks the ascending order. we mark it as index i
        then we'd like to find the minimum element who is greater than the number at index i. Since all the elements after index i is already in descending order. we just go as much as possible. Then we swap these two.
        now we just need to reverse the rest of numbers since it's already sorted
        */
        if(nums==null||nums.length==1)  return;
        int i,j;
        for (i=nums.length-2;i>=0&&nums[i]>=nums[i+1];i--)
            ;
        if(i>=0){
            for (j=i+1;j<nums.length&&nums[j]>nums[i];j++)
            ;
           swap(nums,i,j-1);
        }
        i++;
        int k=nums.length-1;
        for(;i<k;i++,k--){
            swap(nums,i,k);
        }
    }
    
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}