/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s=="")   return true;
        int start=0;
        int end=s.length()-1;
        while(start<=end){
            if((s.charAt(start)>='a'&&s.charAt(start)<='z')||(s.charAt(start)>='A'&&s.charAt(start)<='Z')||(s.charAt(start)>='0'&&s.charAt(start)<='9'))
                ;
            else{
                start++;
                continue;
            }
            if((s.charAt(end)>='a'&&s.charAt(end)<='z')||(s.charAt(end)>='A'&&s.charAt(end)<='Z')||(s.charAt(end)>='0'&&s.charAt(end)<='9'))
                ;
            else{
                end--;
                continue;
            }
            if(s.charAt(start)==s.charAt(end)){
                    start++;
                    end--;
            }
            else{
                if  ((s.charAt(start)>='a'&&s.charAt(start)<='z'&&s.charAt(end)>='A'&&s.charAt(end)<='Z'&&s.charAt(start)==s.charAt(end)+'a'-'A')||(s.charAt(end)>='a'&&s.charAt(end)<='z'&&s.charAt(start)>='A'&&s.charAt(start)<='Z'&&s.charAt(start)==s.charAt(end)+'A'-'a')){
                    start++;
                    end--;
                }
                else{
                    return false;
                }
            }
        
        }
        return true;
    }
}