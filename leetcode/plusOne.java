/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)  return digits;
        int add=1;
        int promotion=0;
        int index=digits.length-1;
        while(index>=0){
            int digit=(digits[index]+add+promotion)%10;
            promotion=(digits[index]+add+promotion)/10;
            digits[index]=digit;
            add=0;
            if(promotion==0)
                return digits;
            index--;
        }
        if(index==-1){
            int[] result=new int[digits.length+1];
            result[0]=1;
            return result;
        }
        return digits;
    
    }
}