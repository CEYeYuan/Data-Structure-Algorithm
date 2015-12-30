/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] arr=new boolean[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=false;
        }
        //use the array to memorize if s.substring(i) can be segmented into words
        for(int i=arr.length-1;i>=0;i--){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==true&&wordDict.contains(s.substring(i,j)))
                    arr[i]=true;
            }
            if(arr[i]==false){
                if(wordDict.contains(s.substring(i)))
                    arr[i]=true;
            }
        }
        return arr[0];
    }
}