/*
####
we start from the last char in the array, and go backwards.
we assume we will current char is the first char
So if the last char is 0, there is no way, if the last char is not 0, there is one way
then we move to the second last char
if(second last char==0)	start from this char=0
else (second last char+last char<=26)	start from this char=start from next char + start 
		from the char after next char
else start from this char=start from next char

####

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
public class Solution {
    public int numDecodings(String s) {
        /* standard way
        if(s==null||s.length()==0)  return 0;
        int[] res=new int[s.length()+1];
        res[s.length()]=1;
        res[s.length()-1]=s.charAt(s.length()-1)=='0'?0:1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='0')  res[i]=0;
            else
                res[i]=Integer.parseInt(s.substring(i,i+2))<=26?res[i+1]+res[i+2]:res[i+1];
        }
        return res[0];
        */
        if(s==null||s.length()==0)  return 0;
        int n1,n2;
        n2=1;
        n1=s.charAt(s.length()-1)=='0'?0:1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='0'){
                n2=n1;
                n1=0;
            }    
            else{
                int tmp=Integer.parseInt(s.substring(i,i+2))<=26?n1+n2:n1;
                n2=n1;
                n1=tmp;
            }
        }
        return n1;
    }
}