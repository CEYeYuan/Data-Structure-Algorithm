/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] strbuffer=new StringBuffer[numRows];
        //init the array
        for(int i=0;i<numRows;i++){
            strbuffer[i]=new StringBuffer();
        //init each element inside the array
        }
        int index=0;
        while(index<s.length()){
            for (int i=0;i<numRows&&index<s.length();i++,index++){
                strbuffer[i].append(s.charAt(index));
            }
            for (int i=0;i<numRows-2&&index<s.length();i++,index++){
                strbuffer[numRows-1-1-i].append(s.charAt(index));
            }
        }
        StringBuffer rs=new StringBuffer();
        for (int i=0;i<numRows;i++){
            rs.append(strbuffer[i]);
        }
        return rs.toString();
    }
}