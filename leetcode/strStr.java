/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.

*/
public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int j;
            for(j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            if(j==needle.length())
                return i;
        }
        return -1;
    }
}