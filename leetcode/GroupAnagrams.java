/*
Do not use a char[] as key in hashmap. use a string instead

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
Update (2015-08-09):
The signature of the function had been updated to return list<list<string>> instead of list<string>, as suggested here. If you still see your function signature return a list<string>, please click the reload button  to reset your code definition.
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<List<String>>();
        if(strs==null)  return list;
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        Arrays.sort(strs);
        for(String s:strs){
            char[]arr=s.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(map.get(key)==null){
                ArrayList<String> tmp=new ArrayList<String>();
                tmp.add(s);
                map.put(key,tmp);
            }
            else{
                ArrayList<String> tmp=map.get(key);
                tmp.add(s);
                map.put(key,tmp);
                
            }
            
        }
        for(String s:map.keySet()){
              ArrayList<String> tmp=map.get(s);
              list.add(tmp);
        }
        
        return list;
    }
}