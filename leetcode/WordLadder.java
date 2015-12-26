/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class Solution {
     public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        wordList.add(endWord);
        //track if the word has been visited yet
        map.put(beginWord,-1);
        //use the value to keep track of level. negative means not visited yet
        Queue<String> queue=new LinkedList<String>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
             String word=queue.poll();
             if(map.get(word)>0){
             	continue;
             }
             else{
                //mark as visited
                map.put(word,Math.abs(map.get(word)));
             }
             if(word.equals(endWord))
                return map.get(word);
             for(int i=0;i<word.length();i++){
                
                 char[] array=word.toCharArray();
                 for(int j='a';j<='z';j++){
                     array[i]=(char)j;
                     String tmp=new String(array);
                     if(wordList.contains(tmp)&&new String(tmp).equals(word)==false){
                     	 if(map.get(tmp)==null){
                     	    queue.add(tmp);
                            map.put(tmp,(map.get(word)+1)*-1);
                     	 }
                     }
                 }
            }
        }
        return 0;
        
    }
}