/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        else if(strs.length==1)
            return strs[0];
        else{
            String s=findCommon(strs[0],strs[1]);
            for (int i=2;i<strs.length;i++){
                s=findCommon(s,strs[i]);
            }
            return s;
        }
    }
    private String findCommon(String s1,String s2){
        StringBuffer strbuffer=new StringBuffer();
        if(s1==null||s2==null)
            return "";
        else{
            int i=0;
            int len=Math.min(s1.length(),s2.length());
            while(i<len&&s1.charAt(i)==s2.charAt(i)){
                strbuffer.append(s1.charAt(i));
                i++;
            }
        }
        return strbuffer.toString();
    }
}