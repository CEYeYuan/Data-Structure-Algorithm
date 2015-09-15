/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
public class Solution {
    public int myAtoi(String str) {
        if(str==null||str.length()==0)
            return 0;
        char[] arr=str.toCharArray();
        int i=0;
        int tmp;
        tmp=0;
        long result=0;
        while(i<arr.length-1&&(arr[i]==' '||arr[i]=='\t'||arr[i]=='\n')){
            i++;
        }
        if((arr[i]>'9'||arr[i]<'0')&&(arr[i]!='+'&&arr[i]!='-'))
            return 0;
        else{
            tmp=i;
            if(arr[tmp]=='+'||arr[tmp]=='-')
                i++;
            while(i<arr.length&&arr[i]>='0'&&arr[i]<='9'){
                result=result*10+arr[i]-'0';
                if(result>Integer.MAX_VALUE&&arr[tmp]!='-')
                    return Integer.MAX_VALUE;
                if(result>2147483648l&&arr[tmp]=='-')
                    return Integer.MIN_VALUE;
                    
                i++;
            }
            if(arr[tmp]=='-'){
               result=-1*result;
            }
            if(result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(result<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)result;
        }
    }
}