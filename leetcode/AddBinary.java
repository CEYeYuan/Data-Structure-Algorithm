/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0) return b;
        if(b==null||b.length()==0) return a;
        StringBuffer s=new StringBuffer();
        boolean pro=false;
        int i,j;
        for(i=a.length()-1,j=b.length()-1;i>=0||j>=0||pro;i--,j--){
            char aa=i>=0?a.charAt(i):'0';
            char bb=j>=0?b.charAt(j):'0';
            if(aa=='1'&&bb=='1') {
                if(pro)     s.append("1");
                else    {pro=true; s.append("0");}
            }
            else if(aa=='0'&&bb=='0'){
                if(pro) {pro=false; s.append("1");}
                else    s.append("0");
            }
            else{
                if(pro) s.append("0");
                else    s.append("1");
            }
   
        }
 
        String str=s.toString();
        return reverse(str);
    }
    
    private String reverse(String s){
        if(s==null) return null;
        else{
            StringBuffer buffer=new StringBuffer();
            for(int i=s.length()-1;i>=0;i--){
                buffer.append(s.charAt(i));
            }
            return buffer.toString();
        }
        
    }
}