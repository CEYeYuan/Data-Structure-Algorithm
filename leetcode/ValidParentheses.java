/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/
import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        if(s=="")
            return true;
        else{
            boolean rs;
            for (int i=0;i<s.length();i++){
                if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                    st.push(s.charAt(i));
                else{
                    if(st.isEmpty())
                        return false;
                    char ch=st.pop();
                    if (ch=='('&&s.charAt(i)==')')  continue;
                    else if  (ch=='['&&s.charAt(i)==']') continue;
                    else if  (ch=='{'&&s.charAt(i)=='}') continue;
                    else
                        return false;
                }
            }
        }
        
       if (st.isEmpty())
            return true;
       else
            return false;
    }
}