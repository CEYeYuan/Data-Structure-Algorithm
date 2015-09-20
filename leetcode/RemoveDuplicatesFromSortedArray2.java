/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)   return 0;
        int i,j,counter;
        counter=i=j=1;
        for(;j<nums.length;j++){
            if(nums[j]!=nums[j-1]){
                counter=1;
                nums[i++]=nums[j];
            }
            else{
                counter++;
                if (counter>2)  continue;
                else
                    nums[i++]=nums[j];
                
            }
        }
        return i;
    }
}