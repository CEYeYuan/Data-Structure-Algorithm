/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
        int lowerBound,upperBound,max;
        lowerBound=upperBound=max=0;
        for(int i=0;i<s.length();i++){
            if(!hs.containsKey(s.charAt(i))){
                upperBound=i;
                max=Math.max(upperBound-lowerBound+1,max);
                hs.put(s.charAt(i),i);
            }
            else{
                if(lowerBound<hs.get(s.charAt(i))+1)
                /*
                	Why We need this line of code ? We don't want to go backwards !
					for instance "abba" when i=3
					lowerBound=2,hs.get(s.charAt(i))+1=1
					we don't want start with the first b again
				*/
                    lowerBound=hs.get(s.charAt(i))+1;
                upperBound=i;
                max=Math.max(upperBound-lowerBound+1,max);
                hs.put(s.charAt(i),i);
            }
        }
        return max;
    }
}