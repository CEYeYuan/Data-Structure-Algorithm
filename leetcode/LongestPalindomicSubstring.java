/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        if(s==null)     return null;
        else if(s.length()==0)   return new String("");
        int[] result=longest(s);
        return s.substring(result[0],result[1]+1);
    }
    private int[] longest(String s){
        int start,end,max,cur;
        start=end=0;
        max=1;
        for(int i=0;i<s.length();i++){
            int j=1;
            cur=1;
            while((i-j>=0)&&(i+j<s.length())){
                if(s.charAt(i-j)==s.charAt(i+j)){
                    j++;
                    cur+=2;
                }
                else
                    break;
            }
            if(cur>max){
                max=cur;
                start=i-j+1;
                end=i+j-1;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1))  continue;
            int j=1;
            cur=2;
            while((i-j>=0)&&(i+j+1<s.length())){
                if(s.charAt(i-j)==s.charAt(i+1+j)){
                    j++;
                    cur+=2;
                }
                else
                    break;
            }
            if(cur>max){
                max=cur;
                start=i-j+1;
                end=i+j;
            }
        }
            return new int[]{start,end};
    }
}