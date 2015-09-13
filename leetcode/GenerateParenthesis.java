/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        if(n==0)
            return list;
        else if(n==1){
            list.add("()");
            return list;
        }else{
            list=generateParenthesis(n-1);
            List<String> rs=new ArrayList<String>();
            for(String s:list){
                if(!list.contains(s+"()"))
                     rs.add(s+"()");
                if(!list.contains("()"+s))
                    rs.add("()"+s);
                if(!list.contains("("+s+")"))
                    rs.add("("+s+")");
            }
            list=rs;
            return list;
        }
    }
}