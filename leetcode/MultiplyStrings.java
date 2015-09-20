/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0) return new String("");
        int[] res=new int[num1.length()+num2.length()];
        for(int i=num2.length()-1;i>=0;i--){
            int carry=0;
            for(int j=num1.length()-1;j>=0;j--){
                int tmp=((num2.charAt(i)-'0')*(num1.charAt(j)-'0')+carry+res[i+j+1]);
                res[i+j+1]=tmp%10;
                //System.out.println(tmp);  
                carry=tmp/10;
                //System.out.println("carry= "+carry); 
            }
            if(carry!=0){
                res[i]=carry;
            }
        }
        int i=0;
        while(i<res.length-1&&res[i]==0){
            i++;
        }
        
        StringBuffer buffer=new StringBuffer();
        for(;i<res.length;i++){
            buffer.append(res[i]);
        }
        return buffer.toString();
    }
}