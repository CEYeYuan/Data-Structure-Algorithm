/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public String intToRoman(int num) {
        /*
         I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000. In this system, a letter placed after 
         another of greater value adds (thus XVI or xvi is 16), whereas a letter placed before another of 
         greater value subtracts (thus XC or xc is 90).
        */
        int[] arr=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            while(num>=arr[i]){
                buffer.append(roman[i]);
                num-=arr[i];
            }
        }
        return buffer.toString();
    }
}