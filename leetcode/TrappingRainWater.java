/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
public class Solution {
    public int trap(int[] height) {
        if(height==null||height.length<=2)  return 0;
       /*
       every time when we reach an index that's not max, there must be some water
       trapped in that index (from both left to right and right to left)
       */
       int left=0;
       int right=height.length-1;
       int leftmax=height[left];
       int rightmax=height[right];
       int total=0;
       while(left<right){
           //traverse every index
           if(leftmax>rightmax){
               //we can trap rightmax-height[index] water
               if(height[--right]>rightmax)     rightmax=height[right];
               else                 total+=rightmax-height[right];
           }
           else{
               //we can trap leftmax-height[index] water
               if(height[++left]>leftmax)       leftmax=height[left];
               else                 total+=leftmax-height[left];
           }
       }
       return total;
       
    }
}