/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
###corner case
1.the num of digits in each number must match its own range 0-9 10-99 100-255
2.when use substring, make sure the second index <= s.length()
3.remeber adding "."

*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuffer buffer=new StringBuffer();
        List<String> list=new ArrayList<String>();
        if(s==null||s.length()==0)      return list;
        recurse(list,0,3,buffer,s);
        return list;
        
    }
    private void recurse(List<String> list,int pos,int left,StringBuffer cur,String s){
        if(left==0&&((s.length()-pos>3)||(s.length()-pos<=0))){
            return ;
        }
        else if(left==0){
            String tmp=s.substring(pos);
              if((tmp.length()==1&&Integer.parseInt(tmp)>=0&&(Integer.parseInt(tmp)<=9))||
                    (tmp.length()==2&&Integer.parseInt(tmp)>=10&&(Integer.parseInt(tmp)<=99))
                    ||(tmp.length()==3&&Integer.parseInt(tmp)>=100&&(Integer.parseInt(tmp)<=255))){
                  cur.append(s.substring(pos));
                  list.add(cur.toString());
            }
            return;  
        }
        else{
            for(int i=1;i<=3;i++){
                if(pos+i>s.length())  break;
                String tmp=s.substring(pos,pos+i);
                if(tmp.length()>=0){
                    if((tmp.length()==1&&Integer.parseInt(tmp)>=0&&(Integer.parseInt(tmp)<=9))||
                    (tmp.length()==2&&Integer.parseInt(tmp)>=10&&(Integer.parseInt(tmp)<=99))
                    ||(tmp.length()==3&&Integer.parseInt(tmp)>=100&&(Integer.parseInt(tmp)<=255))){
                        StringBuffer copy=new StringBuffer(cur);
                        copy.append(tmp);
                        copy.append(".");
                        recurse(list,pos+i,left-1,copy,s);
                    }
                    
                }
            }
        }
        
    }
}