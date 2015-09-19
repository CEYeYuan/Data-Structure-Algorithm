/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        /*
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211
        */
        if(n==1)    return new String("1");
        String s=countAndSay(n-1);
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++){
            char count='1';
            char current=s.charAt(i);
            while(i+1<s.length()&&s.charAt(i+1)==current){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(current);
        }
        return sb.toString();
        
        
    }
}