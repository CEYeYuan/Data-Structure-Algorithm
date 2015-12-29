/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret=new ArrayList<>();
        char[] arr=s.toCharArray();
        List<String> cur=new ArrayList<String>();
        recurse(ret,s,cur);
        return ret;
    }
    
    private void recurse(List<List<String>> ret,String s,List<String> cur){
        if(s.length()==0){
            ret.add(cur);
            return;
        }
        else{
            for(int i=1;i<=s.length();i++){
                String sub=s.substring(0,i);
                if(isPalindrome(sub)){
                    List<String> copy=new ArrayList<String>(cur);
                    copy.add(sub);
                    recurse(ret,s.substring(i),copy);
                }
            }
        }
    }
    
    private boolean isPalindrome(String str){
        int h=str.length()-1;
        int l=0;
        while(l<=h){
            if(str.charAt(l)!=str.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
}