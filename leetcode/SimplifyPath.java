/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0)  return "";
        char[] arr=path.toCharArray();
        LinkedList<String> list=new LinkedList<String>();
        int i=1;
        list.add("/");
        while(i<arr.length){
           String tmp=nextLevel(arr,i);
           i+=tmp.length()+1;
           if(tmp.equals("..")){
               if(list.size()>1)    list.removeLast();
               else     continue;
           } 
           else if(tmp.equals("."))     continue;
           else if(tmp.equals("")) continue;
           else     list.add(tmp+"/");
           
        }
        StringBuffer buff=new StringBuffer();
        for(String s:list){
            buff.append(s);
        }
        String ret= buff.toString();
        int len=ret.length();
        if(len>1)    return ret.substring(0,len-1);
        else    return ret;
    }
    
    private String nextLevel(char[]input,int i){
        if(i>=input.length||input[i]=='/')     return "";
        StringBuffer buffer =new StringBuffer();
        buffer.append(input[i++]);
        while(i<input.length&&input[i]!='/'){
            buffer.append(input[i]);
            i++;
        }
       
        return buffer.toString();
    }
}