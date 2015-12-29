import java.util.*;
public class test {
	public static void main(String[] args){
		String a="hit";
		String b="cog";
		HashSet<String> set=new HashSet<String>();
		set.add("hot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		set.add("dot");
		System.out.println(ladderLength(a,b,set));
	} 

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