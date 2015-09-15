/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list=new ArrayList<String>();
        if(digits==null||digits.length()==0)    return list;
        else if(digits.length()==1){
            char[] tmp=letters[Integer.parseInt(digits)-2].toCharArray();
            for(char ch:tmp){
                list.add(ch+"");
            }
            return list;
        }
    
        
        else{
            list=letterCombinations(digits.substring(0,digits.length()-1));
            int num=Integer.parseInt(digits.substring(digits.length()-1));
            List<String> result=new ArrayList<String>();
            char[] combinations=letters[num-2].toCharArray();
            HashSet<String> hs=new HashSet<String>();
            for(String s:list){
                for(int i=0;i<combinations.length;i++){
                    String tmp=s+combinations[i];
                    if(!hs.contains(tmp))
                        hs.add(tmp);
                }
            }
            for(String s:hs){
                result.add(s);
            }
            return result;
        }
    }
}