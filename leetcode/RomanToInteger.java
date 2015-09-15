/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public int romanToInt(String s) {
         /*
         I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000. In this system, a letter placed after 
         another of greater value adds (thus XVI or xvi is 16), whereas a letter placed before another of 
         greater value subtracts (thus XC or xc is 90).
        */
        if(s==null) return 0;
        int[] arr=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int result=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<roman.length;j++){
                if((i+1)<s.length()&&roman[j].equals(s.substring(i,i+2))){
                    result+=arr[j];
                    i+=1;
                    break;
                }
                else if(i<s.length()&&roman[j].equals(s.substring(i,i+1))){
                    result+=arr[j];
                    break;
                }
            }
        }
        return result;
        
    }
}