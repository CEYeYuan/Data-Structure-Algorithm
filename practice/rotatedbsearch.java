public class Solution {
    public int search(int[] nums, int target) {
        int hi,lo;
        lo=0;
        hi=nums.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(target==nums[mid])   return mid;
            if(nums[lo]<=nums[mid]){
                if(target<=nums[mid]&&target>=nums[lo])    hi=mid-1;
                else        lo=mid+1;
            }
            if(nums[mid]<=nums[hi]){
                if(target>=nums[mid]&&target<=nums[hi])    lo=mid+1;
                else        hi=mid-1;
            }
            
        }
        return -1;
        
    }    
}