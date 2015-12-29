/*
Given an integer, write a function to determine if it is a power of two.
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0)
            return false;
        int count=0;
        for(int i=0;i<32;i++){
            if((n>>i&1)==1)
                count++;
        }
        return count==1;
        
    }
}
