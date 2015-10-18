// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Scanner;
import java.util.*;
class test{
    public static void main(String[]args){
         Scanner sc=new Scanner(System.in);
         String s=sc.nextLine();
         int i=substring(s);
         System.out.println(i);
        
    } 
    private static int  substring(String s){
       
       HashSet<String> set=new HashSet<String>();
       for(int len=0;len<=s.length();len++){
           //add all substring with len length
           for(int i=0;i<s.length()-len;i++){
               //i means start point
               String sub=s.substring(i,i+len+1);
               set.add(sub);
           }
       }
       return set.size();
    }
}

